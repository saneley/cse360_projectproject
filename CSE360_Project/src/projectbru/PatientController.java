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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PatientController {
	@FXML
	private BorderPane rootP;
		
	private Stage stage;
	private Scene scene;
	
	@FXML
	private Label username;
	
	public void setUsername(String uname)
	{
		username.setText(uname);
	}
	
	public void switchToList(ActionEvent event) throws IOException {
		AnchorPane pain = FXMLLoader.load(getClass().getResource("ScanListView.fxml"));
		rootP.setCenter(pain);
		
	}
	
	public void switchToMessages(ActionEvent event) throws IOException {
		VBox pain = FXMLLoader.load(getClass().getResource("MessageBoard.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(pain);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToSettings(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Settings.fxml"));
		AnchorPane pain = loader.load();
		SettingsController settingcontroller = loader.getController();
		settingcontroller.setUsername(username.getText()); //passes parameters to patientcontroller
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(pain);
		stage.setScene(scene);
		stage.show();
	}
	
	public void backToPatient(ActionEvent event) throws IOException {
		BorderPane pain = FXMLLoader.load(getClass().getResource("PatientView.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(pain);
		stage.setScene(scene);
		stage.show();
	}
	
	public void logOut(ActionEvent event) throws IOException {
		AnchorPane pain = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(pain);
		stage.setScene(scene);
		stage.show();
	}
}
