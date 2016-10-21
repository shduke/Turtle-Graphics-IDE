package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * @author Noel Moon (nm142)
 * @author John Martin
 *
 */
public class InputField extends HorizontalGUIObject {
    
	protected static TextField myTextField;
	private EventHandler<ActionEvent> myEnterHandler;
	
	public InputField(String language) {
		super(language);
		myEnterHandler = new EnterEvent();
		myTextField = makeInputField((int) (SlogoView.getAppWidth() * 0.075), myEnterHandler);
	}
	
	private class EnterEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle (ActionEvent event) {
			String input = myTextField.getText();
			SlogoView.myHistory.addHistory(input);
			myTextField.clear();
		}
	}

	protected HBox getInputField() {
		HBox result = new HBox();
		result.getChildren().add(myTextField);
		result.getChildren().add(makeButton("EnterCommand", myEnterHandler));
		return result;
	}
    
	private TextField makeInputField (int width, EventHandler<ActionEvent> handler) {
		TextField result = new TextField();
		result.setPrefColumnCount(width);
		result.setOnAction(handler);
		return result;
	}
    
    
}
