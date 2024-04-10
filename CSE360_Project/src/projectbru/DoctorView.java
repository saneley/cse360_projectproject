package application;

import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Sample data
        String firstName = "John";
        String lastName = "Doe";
        String pharmacyName = "ABC Pharmacy";

        // Top center title
        Label titleLabel = new Label("Doctor View");

        // Left top patient overview
        Label patientOverviewLabel = new Label("Patient Overview: " + firstName + ", " + lastName);
        Label pharmacyLabel = new Label("Pharmacy: " + pharmacyName);

        // Text areas for physical test notes and new medication
        TextArea physicalTestNotesTextArea = new TextArea();
        Label physicalTestNotesLabel = new Label("Physical Test Notes");
        TextArea newMedicationTextArea = new TextArea();
        Label newMedicationLabel = new Label("New Medication");

        // Patient history section
        Label patientHistoryLabel = new Label("Patient History");
        Label healthIssuesLabel = new Label("Health Issues");
        Label prescribedMedicationLabel = new Label("Prescribed Medication");
        Label immunizationRecordLabel = new Label("Immunization Record");
        TextArea healthIssuesTextArea = new TextArea();
        TextArea prescribedMedicationTextArea = new TextArea();
        TextArea immunizationRecordTextArea = new TextArea();

        // Log Off button
        Button logOffButton = new Button("Log Off");
        logOffButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                saveDoctorInfo(firstName + lastName, physicalTestNotesTextArea, newMedicationTextArea,
                        healthIssuesTextArea, prescribedMedicationTextArea, immunizationRecordTextArea);
            }
        });

        // Layout setup
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(titleLabel);

        GridPane leftGridPane = new GridPane();
        leftGridPane.setPadding(new Insets(10));
        leftGridPane.setVgap(10);
        leftGridPane.add(patientOverviewLabel, 0, 0);
        leftGridPane.add(pharmacyLabel, 0, 1);
        leftGridPane.add(physicalTestNotesLabel, 0, 2);
        leftGridPane.add(physicalTestNotesTextArea, 0, 3);
        leftGridPane.add(newMedicationLabel, 0, 4);
        leftGridPane.add(newMedicationTextArea, 0, 5);
        borderPane.setLeft(leftGridPane);

        GridPane rightGridPane = new GridPane();
        rightGridPane.setPadding(new Insets(10));
        rightGridPane.setVgap(10);
        rightGridPane.add(patientHistoryLabel, 0, 0);
        rightGridPane.add(healthIssuesLabel, 0, 1);
        rightGridPane.add(healthIssuesTextArea, 0, 2);
        rightGridPane.add(prescribedMedicationLabel, 0, 3);
        rightGridPane.add(prescribedMedicationTextArea, 0, 4);
        rightGridPane.add(immunizationRecordLabel, 0, 5);
        rightGridPane.add(immunizationRecordTextArea, 0, 6);
        borderPane.setRight(rightGridPane);

        borderPane.setBottom(logOffButton);

        Scene scene = new Scene(borderPane, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Doctor View");
        primaryStage.show();
    }

    private void saveDoctorInfo(String id, TextArea physicalTestNotesTextArea, TextArea newMedicationTextArea,
                                TextArea healthIssuesTextArea, TextArea prescribedMedicationTextArea,
                                TextArea immunizationRecordTextArea) {
        try {
            FileWriter writer = new FileWriter(id + "_PatientInfo.txt");
            writer.write("Physical Test Notes:\n" + physicalTestNotesTextArea.getText() + "\n\n");
            writer.write("New Medication:\n" + newMedicationTextArea.getText() + "\n\n");
            writer.write("Health Issues:\n" + healthIssuesTextArea.getText() + "\n\n");
            writer.write("Prescribed Medication:\n" + prescribedMedicationTextArea.getText() + "\n\n");
            writer.write("Immunization Record:\n" + immunizationRecordTextArea.getText() + "\n\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
