package view.slogoWindowElements;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import view.SlogoWindowView;

/**
 * @author Noel Moon
 *
 */
public class InputField implements IInputField {
    
    public static TextArea myTextArea;
    private EventHandler<ActionEvent> myEnterHandler;
    private ResourceBundle myResources;
    private IHistory myHistory;
    
    public InputField(String language, IHistory history) {
        myResources = ResourceBundle.getBundle(SlogoWindowView.DEFAULT_RESOURCE_PACKAGE + language);
        myEnterHandler = new EnterEvent();
        myTextArea = makeInputField((int) (SlogoWindowView.myAppWidth * 0.075), myEnterHandler);
        myHistory = history;
    }

    public HBox getInputField() {
        HBox result = new HBox();
        result.getChildren().add(myTextArea);
        result.getChildren().add(makeButton("EnterCommand", myEnterHandler));
        return result;
    }
    
    private class EnterEvent implements EventHandler<ActionEvent> {
        @Override
        public void handle (ActionEvent event) {
            String input = myTextArea.getText();
            myHistory.addHistory(input);
            myTextArea.clear();
        }
    }
    
    private TextArea makeInputField (int width, EventHandler<ActionEvent> handler) {
        TextArea result = new TextArea();
        result.setPrefColumnCount(width);
        result.setPrefHeight(100);
        //result.setOnAction(handler);
        return result;
    }
    
    private Button makeButton (String property, EventHandler<ActionEvent> handler) {
        Button result = new Button();
        String label = myResources.getString(property);
        result.setText(label);
        result.setOnAction(handler);
        return result;
    }
}
