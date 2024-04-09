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
import javafx.stage.Stage;

public class PatientController {
	@FXML
	private BorderPane rootP;
	private Stage stage;
	private Scene scene;
	
	
	public void switchToList(ActionEvent event) throws IOException {
		AnchorPane pain = FXMLLoader.load(getClass().getResource("ScanListView.fxml"));
		rootP.setCenter(pain);
		
	}
	
	public void switchToMessage(ActionEvent event) throws IOException {
		//NEED THE MESSAGEBOARD WINDOW
		AnchorPane pain = FXMLLoader.load(getClass().getResource("ScanListView.fxml"));
		rootP.setCenter(pain);
		
	}
	
	public void logOut(ActionEvent event) throws IOException {
		AnchorPane pain = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(pain);
		stage.setScene(scene);
		stage.show();
	}
}
