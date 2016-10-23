package view;

import java.awt.Dimension;

import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;

public class ChooseLanguageWindow {
	
	public static final Dimension DEFAULT_SIZE = new Dimension(400, 400);
	
	private Scene myScene;
	private ChoiceBox<String> myChoiceBox;
	
	ChooseLanguageWindow() {
		BorderPane root = new BorderPane();
		root.setCenter(makeLanguageDisplay());
		myScene = new Scene(root, DEFAULT_SIZE.getWidth(), DEFAULT_SIZE.getHeight());
		myChoiceBox = new ChoiceBox<String>();
	}

	private ChoiceBox<String> makeLanguageDisplay() {
		myChoiceBox.setItems(FXCollections.observableArrayList("Chinese", "English", "French", "German", "Italian", "Portuguese", 
				"Russian", "Spanish"));
		return myChoiceBox;
	}
	
	public Scene getScene(){
		return myScene;
	}
}
