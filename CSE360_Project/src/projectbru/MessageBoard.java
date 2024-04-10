package projectbru;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MessageBoard {

    private static final ObservableList<String> messages = FXCollections.observableArrayList();

    @FXML
    private ListView<String> messageListView;
    @FXML
    private TextField messageTextField;

    @FXML
    public void initialize() {
        messageListView.setItems(messages);
    }

    @FXML
    private void postMessage() {
        String message = messageTextField.getText();
        if (!message.trim().isEmpty()) {
            messages.add(message);
            messageTextField.clear();
        }
    }
}