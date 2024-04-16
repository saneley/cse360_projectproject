package projectbru;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SettingsController {
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
	private String pTemp;
	
	public void setUsername(String uname) throws IOException
	{
		username.setText(uname);
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(uname+".txt"));
			pTemp=bf.readLine();
			
			String rd = bf.readLine();
			if(rd != null) {
				ll1.setText(rd);
				ll2.setText(bf.readLine());
				ll3.setText(bf.readLine());
				ll4.setText(bf.readLine());
			}
			
			bf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			BufferedWriter fw = new BufferedWriter(new FileWriter(username.getText()+".txt", false));
			
			fw.write(pTemp+"\n");
			ll1.setText(tf1.getText());
			fw.write(tf1.getText()+"\n");
			ll2.setText(tf2.getText());
			fw.write(tf2.getText()+"\n");
			ll3.setText(tf3.getText());
			fw.write(tf3.getText()+"\n");
			ll4.setText(tf4.getText());
			fw.write(tf4.getText()+"\n");
			
			fw.close();
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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("PatientView.fxml"));
		//Parent root = FXMLLoader.load(getClass().getResource("PatientView.fxml"));
		BorderPane pain = loader.load();
		PatientController patientcontroller = loader.getController();
		patientcontroller.setUsername(username.getText()); //passes parameters to patientcontroller
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(pain);
		stage.setScene(scene);
		stage.show();
	}
}
