package view;

import java.awt.Dimension;
import java.io.File;

import controller.SlogoController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ChooseLanguageWindow implements IChooseLanguageWindow {
	
	public static final Dimension DEFAULT_SIZE = new Dimension(200, 100);
	
	private Scene myScene;
	private ComboBox<String> myComboBox;
	private String myLanguage;
	private Stage stage;
	private Stage slogoStage;
	
	public ChooseLanguageWindow() {
		BorderPane root = new BorderPane();
		myComboBox = new ComboBox<String>();
		root.setCenter(makeLanguageDisplay());
		myScene = new Scene(root, DEFAULT_SIZE.getWidth(), DEFAULT_SIZE.getHeight());
	}
	
	public void start() {
		stage = new Stage();
		stage.setTitle("Choose Language");
		stage.setScene(getScene());
		stage.show();
	}
	
	public void close() {
		stage.close();
	}
	
	public String getLanguage() {
		return myLanguage;
	}
	
	public Scene getScene(){
		return myScene;
	}
	
	public Stage getSlogoStage() {
		return slogoStage;
	}
	
	private ComboBox<String> makeLanguageDisplay() {
		myComboBox.getItems().addAll("English", "Chinese", "French", "German", "Italian", "Portuguese", "Russian", "Spanish");
        myComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	myLanguage = newValue;
            	stage.close();
            	/*
            	Stage stage = new Stage();
            	SlogoWindowView display = new SlogoWindowView(getLanguage());
                stage.setTitle("SLogo");
                stage.setScene(display.getScene());
                stage.show();
                */
            	EventHandler<ActionEvent> fileChoose = new FileChooserEvent();
            	
            	slogoStage = new Stage();
            	SlogoWindowView display = new SlogoWindowView(getLanguage(), fileChoose);
                slogoStage.setTitle("SLogo");
                slogoStage.setScene(display.getScene());
                slogoStage.show();
                SlogoController slogo = new SlogoController(display);
                
                
            }
        });
		return myComboBox;
	}
	
	private class FileChooserEvent implements EventHandler<ActionEvent> {
		private FileChooser fileChooser;
		
		@Override
		public void handle(ActionEvent event) {
			fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			fileChooser.showOpenDialog(getSlogoStage());
		}
	}

}
