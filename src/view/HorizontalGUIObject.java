package view;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public abstract class HorizontalGUIObject extends HBox {
    
    private ResourceBundle myResources;
    
    public HorizontalGUIObject(String language) {
        myResources = ResourceBundle.getBundle(SlogoView.DEFAULT_RESOURCE_PACKAGE + language);
        
    }
    
    public ResourceBundle getResources() {
        return myResources;
    }
    
    protected Button makeButton (String property, EventHandler<ActionEvent> handler) {
        Button result = new Button();
        String label = getResources().getString(property);
        result.setText(label);
        result.setOnAction(handler);
        return result;
    }
}
