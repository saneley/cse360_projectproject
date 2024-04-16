package projectbru;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SceneController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	//login to account
	@FXML
	private Button loginPersonnel;
	@FXML
	private Button loginUser;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	
	//output console
	@FXML
	private Label loginConsole;
	
	//create an account
	@FXML
	private TextField firstname;
	@FXML
	private TextField lastname;
	@FXML
	private DatePicker birthday;
	@FXML
	private TextField newPassword;
	@FXML
	private Button createAccount;
	
	/*
	public void switchToScene1(ActionEvent event) throws IOException {
		
		//if (username.getText().toString().equals("nurse") && password.getText().toString().equals("awesomesauce"))
		{
			Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
			
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		//checkLogin();
	}
	*/
	
	public void switchToScene2(ActionEvent event) throws IOException //Personnel login
	{  
		//Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		if (username.getText().toString().equals("nurse") && password.getText().toString().equals("awesomesauce123")) //temporary
		{
			root = FXMLLoader.load(getClass().getResource("NurseView.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		if (username.getText().toString().equals("doctor") && password.getText().toString().equals("doctorsauce123"))
		{
			String dfirstName = "John";
	        String dlastName = "Doe";
	        String pharmacyName = "ABC Pharmacy";

	        // Top center title
	        Label titleLabel = new Label("Doctor View");

	        // Left top patient overview
	        Label patientOverviewLabel = new Label("Patient Overview: " + dfirstName + ", " + dlastName);
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
	            public void handle(ActionEvent event){
	                saveDoctorInfo(dfirstName + dlastName, physicalTestNotesTextArea, newMedicationTextArea,
	                        healthIssuesTextArea, prescribedMedicationTextArea, immunizationRecordTextArea);	                
					try //taken from PatientController
					{
						AnchorPane pain;
						pain = FXMLLoader.load(getClass().getResource("MainView.fxml"));
						stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		        		scene = new Scene(pain);
		        		stage.setScene(scene);
		        		stage.show();
		                
					} catch (IOException e) {
						// TODO Auto-generated catch block
					}
	                
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
	        
	        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        scene = new Scene(borderPane, 1200, 800);
	        stage.setScene(scene);
	        stage.setTitle("Doctor View");
	        stage.show();
		}
		else
		{
			loginConsole.setText("Invalid Personnel Login");
		}
	}
	public void switchToScene3(ActionEvent event) throws IOException //Patient Login
	{
		//if (username.getText().toString().equals("PatientZero") && password.getText().toString().equals("epicsauce123")) //temporary
		if(checkLogin())
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientView.fxml"));
			//Parent root = FXMLLoader.load(getClass().getResource("PatientView.fxml"));
			root = loader.load();
			PatientController patientcontroller = loader.getController();
			patientcontroller.setUsername(username.getText()); //passes parameters to patientcontroller
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else
		{
			loginConsole.setText("Invalid Patient Login");
		}
	}
	public void makeThatAccount(ActionEvent event) throws IOException { //Account creation 
		String fname = firstname.getText();
		String lname = lastname.getText();
		//String bday = birthday.getValue().toString();
		String nPassword = newPassword.getText();
		if (fname.isEmpty() || lname.isEmpty() || (birthday.getValue() == null) || nPassword.isEmpty())
		{
			loginConsole.setText("ERROR: Account creation fields not filled out");
			return;
		}
		String bday = birthday.getValue().toString();//returns a null pointer exception there was no input so i had to move it here
		
		String newUsername = fname.substring(0,1) + lname + bday.substring(2,4);
		File file = new File(newUsername + ".txt");
		if(file.exists())
		{
			loginConsole.setText("ERROR: Account exists already");
			return;
		}
				
		
		try (FileWriter writer = new FileWriter(file))
		{
			writer.write(nPassword + '\n');
			
			loginConsole.setText("SUCCESS: Account created. Your username is " + newUsername);
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	private boolean checkLogin() throws IOException {
		File file = new File(username.getText() + ".txt");
		if(!file.exists())
		{
			//loginConsole.setText("Username '" + username.getText() + "' does not exist" );
			return false;
		}
		Scanner scanner = new Scanner(file);
		String userPassword = scanner.next();
		scanner.close();
		if(userPassword.equals(password.getText()))
		{
			return true;
		}
		//loginConsole.setText(password.getText() + " is not equal to " + userPassword);
		return false;

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

}
