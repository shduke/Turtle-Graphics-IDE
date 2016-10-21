package view;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Noel Moon
 * @author John Martin
 *
 */
public class TestView extends Application {
    public static final String TITLE = "SLogo";
    
    public void start (Stage stage) {
        SlogoView display = new SlogoView("English");
        stage.setTitle(TITLE);
        stage.setScene(display.getScene());
        stage.show();
    }
    
    
    public static void main (String[] args) {
        launch(args);
    }
}
