package main;
import javafx.application.Application;
import javafx.stage.Stage;
import view.chooseLanguage.ChooseLanguageWindow;
import view.chooseLanguage.IChooseLanguageWindow;

public class Main extends Application {

	public static final String TITLE = "SLogo";

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		IChooseLanguageWindow window = new ChooseLanguageWindow();
		window.start();
		
	}

}
