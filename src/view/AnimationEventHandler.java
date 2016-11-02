package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AnimationEventHandler implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent event) {
		String stringNumTurtles = myNumTurtles.getText();
		boolean errorCaught = false;
		try {
			Integer.parseInt(stringNumTurtles);
		} catch (Exception e){
			errorCaught = true;
		}
		// TODO: refactor to an error popup
		if (!errorCaught){
			// Proceed to slogo
		}
	}
}
