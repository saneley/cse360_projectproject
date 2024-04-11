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
import javafx.stage.Stage;

public class PatientController {
	@FXML
	private BorderPane rootP;
	@FXML
	private GridPane gridP;
	@FXML
	private HBox bootuns;
	private Stage stage;
	private Scene scene;
	
	@FXML
	private Button confirm;

	@FXML
	private Label l1;
	@FXML
	private Label ll1;
	@FXML
	private TextField tf1;
	@FXML
	private Label l2;
	@FXML
	private Label ll2;
	@FXML
	private TextField tf2;
	@FXML
	private Label l3;
	@FXML
	private Label ll3;
	@FXML
	private TextField tf3;
	@FXML
	private Label l4;
	@FXML
	private Label ll4;
	@FXML
	private TextField tf4;
	
	@FXML
	private Label username;

	
	public void switchToList(ActionEvent event) throws IOException {
		AnchorPane pain = FXMLLoader.load(getClass().getResource("ScanListView.fxml"));
		rootP.setCenter(pain);
		
	}
	
	public void switchToMessage(ActionEvent event) throws IOException {
		//NEED THE MESSAGEBOARD WINDOW
		AnchorPane pain = FXMLLoader.load(getClass().getResource("ScanListView.fxml"));
		rootP.setCenter(pain);
		
	}
	
	public void switchToSettings(ActionEvent event) throws IOException {
		AnchorPane pain = FXMLLoader.load(getClass().getResource("Settings.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(pain);
		stage.setScene(scene);
		stage.show();
	}
	
	public void editText(ActionEvent event) throws IOException {
		//Allows the Settings to be edited. NEEDS TO BE FINISHED
		for(Node child : gridP.getChildren()) {
			child.setVisible(!child.isVisible());
		}
		for(Node child : bootuns.getChildren()) {
			child.setVisible(!child.isVisible());
		}
		
		l1.setVisible(true);
		l2.setVisible(true);
		l3.setVisible(true);
		l4.setVisible(true);
	}
	
	public void canCon(ActionEvent event) throws IOException {
		//Confirm OR Cancel options
		if(confirm.isArmed()) {
			ll1.setText(tf1.getText());
			ll2.setText(tf2.getText());
			ll3.setText(tf3.getText());
			ll4.setText(tf4.getText());
		}
		
		for(Node child : gridP.getChildren()) {
			child.setVisible(!child.isVisible());
		}
		bootuns.setVisible(true);
		for(Node child : bootuns.getChildren()) {
			child.setVisible(!child.isVisible());
		}
		
		l1.setVisible(true);
		l2.setVisible(true);
		l3.setVisible(true);
		l4.setVisible(true);
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
	
	public void setUsername(String uname)
	{
		username.setText(uname);
	}
}
