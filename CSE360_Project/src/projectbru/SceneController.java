package projectbru;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	public void switchToScene2(ActionEvent event) throws IOException {
		//Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		if (username.getText().toString().equals("nurse") && password.getText().toString().equals("awesomesauce123"))
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
	public void switchToScene3(ActionEvent event) throws IOException {
		if (username.getText().toString().equals("PatientZero") && password.getText().toString().equals("epicsauce123"))
		{
			root = FXMLLoader.load(getClass().getResource("PatientView.fxml"));
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
