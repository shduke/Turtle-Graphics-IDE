package view;

import javafx.application.Application;
import javafx.stage.Stage;
import view.chooseLanguage.ChooseLanguageWindow;

/**
 * @author Noel Moon
 * @author John Martin
 *
 */
public class TestView extends Application {
    public static final String TITLE = "SLogo";
    
    public void start (Stage stage) {
    	ChooseLanguageWindow window = new ChooseLanguageWindow();
		window.start();
    }
    
    
    public static void main (String[] args) {
        launch(args);
    }
}
