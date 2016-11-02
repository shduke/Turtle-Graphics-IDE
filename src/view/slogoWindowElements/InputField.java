package view.slogoWindowElements;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PopupControl;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import view.AppResources;
import view.SlogoWindowView;

/**
 * @author Noel Moon
 *
 */
public class InputField implements IInputField {
    
    private TextArea myTextArea;
    HBox myHBox = new HBox();
    private EventHandler<ActionEvent> myEnterHandler;
    private ResourceBundle myResources;
    private IHistory myHistory;
    
    public InputField(String language, IHistory history) {
        myResources = ResourceBundle.getBundle(SlogoWindowView.DEFAULT_RESOURCE_PACKAGE + language);
        myEnterHandler = new EnterEvent();
        myTextArea = makeInputField((int) (SlogoWindowView.myAppWidth * 0.075), myEnterHandler);
        myHistory = history;
        
        myTextArea.setOnKeyReleased(ev -> {
        	createSuggestion(myTextArea.getText());
        });
    }
    
    private void createSuggestion(String text){
    	if (myTextArea.getContextMenu() != null){
    		myTextArea.getContextMenu().hide();
    	}
    	ArrayList<String> options = new ArrayList<String>();
    	options.add("alphabet");
    	options.add("asd");
    	options.add("afea");
    	options.add("vsdf");
    	options.add("qwe");
    	ArrayList<MenuItem> choices = new ArrayList<MenuItem>();
    	for (String option : options){
    		if (option.startsWith(text)){
    			MenuItem mi = new MenuItem(option);
    			choices.add(mi);
    		}
    		if (choices.size() > 3){
    			break;
    		}
    	}
    	if (choices.size() > 0){
    		System.out.println("set");
    		ContextMenu contextMenu = new ContextMenu();
    		contextMenu.getItems().addAll(choices);
    		contextMenu.setPrefWidth(120);
    	    contextMenu.setMinWidth(PopupControl.USE_PREF_SIZE);
    	    contextMenu.setMaxWidth(PopupControl.USE_PREF_SIZE);
    		contextMenu.setMinHeight(myTextArea.getHeight()); contextMenu.setMaxHeight(myTextArea.getHeight());
    		myTextArea.setContextMenu(contextMenu);
    		contextMenu.show(myTextArea, myTextArea.getWidth() - contextMenu.getPrefWidth(), AppResources.APP_HEIGHT.getDoubleResource());
    	}
    }

    public HBox getInputField() {
        myHBox.getChildren().add(myTextArea);
        myHBox.getChildren().add(makeButton("EnterCommand", myEnterHandler));
        return myHBox;
    }
    
    public void clear() {
    	myTextArea.clear();
    }
    
    private TextArea makeInputField (int width, EventHandler<ActionEvent> handler) {
        TextArea result = new TextArea();
        result.setPrefColumnCount(width);
        result.setPrefHeight(100);
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
    
    private Button makeButton (String property, EventHandler<ActionEvent> handler) {
        Button result = new Button();
        String label = myResources.getString(property);
        result.setText(label);
        result.setOnAction(handler);
        return result;
    }
}
