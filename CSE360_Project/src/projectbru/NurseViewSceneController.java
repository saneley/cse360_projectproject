package projectbru;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.FileWriter;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Label;



public class NurseViewSceneController {

	//patient demographic TextFields
	@FXML
	private TextField fullNameTextField;
	@FXML
	private TextField dobTextField;
	@FXML
	private TextField weightTextField;
	@FXML
	private TextField heightTextField;
	
	//Patient Vital TextFields
	@FXML
	private TextField bodyTempField;
	@FXML
	private TextField bloodPressureText;
	@FXML
	private TextField pulseRateTextField;
	
	//Health Concern TextArea's
	@FXML
	private TextArea symptomsTextArea;
	@FXML
	private TextArea allergyTextArea;
	
	//Patient History TextArea's
	@FXML
	private TextArea healthIssuesText;
	@FXML
	private TextArea immunizationText;
	@FXML
	private TextArea medicationTextArea;
	
	//Buttons
	@FXML
	private Button saveButton;
	@FXML
	private Button logOffButton;
	@FXML
	private Button messageBoardButton;
	
	//handles save button actions
	public void handleSaveButton(ActionEvent event) throws IOException
	{
		String fullName = fullNameTextField.getText();
		//saves all the inputed text into the patients data
		String patientData = fullNameTextField.getText() + ", " + dobTextField.getText() + ", " + weightTextField.getText() + ", " + heightTextField.getText() 
						  + ", " + bodyTempField.getText() + ", " + bloodPressureText.getText() + ", " + pulseRateTextField.getText() + ", " + symptomsTextArea.getText()
						  + ", " + allergyTextArea.getText() + ", " + healthIssuesText.getText() + ", " + immunizationText.getText() + ", " + medicationTextArea.getText();
		
		String fileName = fullName.replaceAll("\\s+", "_") + "_data.csv";
		
		try (FileWriter writer = new FileWriter(fileName, true))
		{
			writer.write(patientData + "\n");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		fullNameTextField.clear();
		dobTextField.clear();
		weightTextField.clear();
		heightTextField.clear();
		bodyTempField.clear();
		bloodPressureText.clear();
		pulseRateTextField.clear();
		symptomsTextArea.clear();
		allergyTextArea.clear();
		healthIssuesText.clear();
		immunizationText.clear();
		medicationTextArea.clear();
		
	}
	public void handleLogOffButton(ActionEvent event) throws IOException
	{
	    Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
	    Scene scene = new Scene(root);
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.setScene(scene);
	    stage.show(); 
	}
	public void handleMessageBoard(ActionEvent event) throws IOException
	{
		/*
	    Parent root = FXMLLoader.load(getClass().getResource(add message board fxml file here));
	    Scene scene = new Scene(root);
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.setScene(scene);
	    stage.show(); 
	    */
	}
}
