package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * @author Noel Moon
 *
 */
public class InputField extends HorizontalGUIObject {
    
    static TextArea myTextArea;
    private EventHandler<ActionEvent> myEnterHandler;
    
    public InputField(String language) {
        super(language);
        myEnterHandler = new EnterEvent();
        myTextArea = makeInputField((int) (SlogoWindowView.myAppWidth * 0.075), myEnterHandler);
    }
    
    private class EnterEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle (ActionEvent event) {
            String input = myTextArea.getText();
            SlogoWindowView.myHistory.addHistory(input);
            myTextArea.clear();
        }
    }

    protected HBox getInputField() {
        HBox result = new HBox();
        result.getChildren().add(myTextArea);
        result.getChildren().add(makeButton("EnterCommand", myEnterHandler));
        return result;
    }
    
    private TextArea makeInputField (int width, EventHandler<ActionEvent> handler) {
        TextArea result = new TextArea();
        result.setPrefColumnCount(width);
        result.setPrefHeight(100);
        //result.setOnAction(handler);
        return result;
    }
    
    
}
