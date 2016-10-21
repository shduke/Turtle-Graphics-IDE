package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

/**
 * @author Noel Moon
 * @author John Martin
 */
public class History extends TextArea {
    
    TextArea myTextArea;
    EventHandler<ActionEvent> myEvent;
    
    public History (EventHandler<ActionEvent> event) {
        myTextArea = new TextArea();
        myEvent = event;
        myTextArea.setEditable(false);
    }
    
    public TextArea getHistory() {
        return myTextArea;
    }
    
    public void addHistory(String input) {
        myTextArea.appendText(input + "\n");
    }
}
