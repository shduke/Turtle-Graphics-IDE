package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * @author Noel Moon
 *
 */
public class InputField extends HorizontalGUIObject {
    
    private TextField myInputField;
    private EventHandler<ActionEvent> myEnterHandler;
    
    public InputField(String language) {
        super(language);
        myEnterHandler = new EnterEvent();
        myInputField = makeInputField((int) (SlogoView.getAppWidth() * 0.075), myEnterHandler);
    }
    
    private class EnterEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle (ActionEvent event) {
            String input = myInputField.getText();
            SlogoView.myHistory.addHistory(input);
            // TODO: Delete following line, just a test line
            SlogoView.myTurtleDisplay.advanceTurtle(50, 50);
            myInputField.clear();
        }
    }

    protected HBox getInputField() {
        HBox result = new HBox();
        result.getChildren().add(myInputField);
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
