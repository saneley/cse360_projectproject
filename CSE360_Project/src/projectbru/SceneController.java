package projectbru;

import java.io.IOException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SceneController {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private Button loginPersonnel;
	@FXML
	private Button loginUser;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	
	
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
		else
		{
			loginConsole.setText("Invalid Personnel Login");
		}
	}
	public void switchToScene3(ActionEvent event) throws IOException //Patient Login
	{
		if (username.getText().toString().equals("PatientZero") && password.getText().toString().equals("epicsauce123")) //temporary
		{
			root = FXMLLoader.load(getClass().getResource("PatientView.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("PatientView.fxml"));
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
	public void makeThatAccount(ActionEvent event) throws IOException {
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
		loginConsole.setText("SUCCESS: Account created. Your username is " + newUsername);
	}
	private void checkLogin() throws IOException {
		//Main m = new Main();
		/*if (username.getText().toString().equals("nurse") && password.getText().toString().equals("awesomesauce"))
		{
			Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		*/
	}

}
