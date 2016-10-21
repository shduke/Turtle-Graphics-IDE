package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

/**
 * @author Noel Moon
 * @author John Martin
 */
public class History extends TextArea {
    
    TextArea myHistory;
    EventHandler<ActionEvent> myEvent;
    
    public History (EventHandler<ActionEvent> event) {
        myHistory = new TextArea();
        myEvent = event;
        myHistory.setEditable(false);
    }
    
    public TextArea getHistory() {
        return myHistory;
    }
    
    public void addHistory(String input) {
        myHistory.appendText(input + "\n");
    }
}
