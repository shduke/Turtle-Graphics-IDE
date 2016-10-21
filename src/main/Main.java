package main;

import controller.AnimationController;
import javafx.application.Application;
import javafx.stage.Stage;
import view.SlogoView;

public class Main extends Application {

	public static final String TITLE = "SLogo";

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) {
		SlogoView display = new SlogoView("English");
		stage.setTitle(TITLE);
		stage.setScene(display.getScene());
		stage.show();
		AnimationController slogo = new AnimationController(display);
	}

}
