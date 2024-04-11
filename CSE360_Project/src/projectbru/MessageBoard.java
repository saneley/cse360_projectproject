package projectbru;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class MessageBoard {

    @FXML
    private ListView<String> messageListView;
    @FXML
    private TextField messageTextField;
    @FXML
    private ComboBox<String> recipientComboBox;
    @FXML
    private Label confirmationLabel;

    private final ObservableList<String> recipientTypes = FXCollections.observableArrayList("Doctor", "Nurse", "Technician", "Patient");
    private final Map<String, ObservableList<String>> messagesByRecipient = new HashMap<>();

    @FXML
    public void initialize() {
        recipientComboBox.setItems(recipientTypes);
        recipientComboBox.getSelectionModel().selectFirst();

        messagesByRecipient.putIfAbsent("Doctor", FXCollections.observableArrayList());
        messagesByRecipient.putIfAbsent("Nurse", FXCollections.observableArrayList());
        messagesByRecipient.putIfAbsent("Technician", FXCollections.observableArrayList());
        messagesByRecipient.putIfAbsent("Patient", FXCollections.observableArrayList());

        messageListView.setItems(messagesByRecipient.get(recipientComboBox.getValue()));

        recipientComboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            messageListView.setItems(messagesByRecipient.get(newVal));
            confirmationLabel.setText(""); 
        });
    }

    @FXML
    private void postMessage() {
        String message = messageTextField.getText();
        String recipient = recipientComboBox.getValue();

        if (!message.trim().isEmpty() && recipient != null) {
            ObservableList<String> recipientMessages = messagesByRecipient.get(recipient);
            if (recipientMessages != null) {
                recipientMessages.add(message);
                messageTextField.clear();
                confirmationLabel.setText("Your message has been sent.");
            }
        }
    }
}
