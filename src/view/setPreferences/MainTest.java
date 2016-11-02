package view.setPreferences;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.SlogoWindowView;

public class MainTest extends Application {
	
	public static void main (String [] args){
		launch(args);
	}

	public void start(Stage stage) {
		PreferencesWindow window = new PreferencesWindow();
		window.start();
		
	}

}
