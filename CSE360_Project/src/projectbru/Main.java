package projectbru;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Orientation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.io.FileWriter;
import java.io.IOException;

public class Main extends Application {
	 
	 @Override
	 public void start(Stage stage) {
	  try {
	   
	   Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
	   Scene scene = new Scene(root);
	   stage.setScene(scene);
	   stage.show();
	   
	  } catch(Exception e) {
	   e.printStackTrace();
	  }
	  
	  
	  //Doctor View----------------
	 } 

	 public static void main(String[] args) {
	  launch(args);
	 }
	}
