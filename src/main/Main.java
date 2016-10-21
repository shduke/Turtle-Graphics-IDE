package main;

import controller.SlogoController;
import javafx.application.Application;
import javafx.stage.Stage;
import view.SlogoWindowView;

public class Main extends Application {

	public static final String TITLE = "SLogo";

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		SlogoWindowView display = new SlogoWindowView("English");
		stage.setTitle(TITLE);
		stage.setScene(display.getScene());
		stage.show();
		SlogoController slogo = new SlogoController(display);
	}

}
