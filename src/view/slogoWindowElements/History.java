package view.slogoWindowElements;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;

/**
 * @author Noel Moon
 * @author John Martin
 */
public class History implements IHistory {
    
    private TextArea myTextArea;
    private ListChangeListener myEventHandler;
    private ObservableList<String> myObservableList;
    
    public History () {
        myTextArea = new TextArea();
        myTextArea.setPrefWidth(300);
        myTextArea.setEditable(false);
        myObservableList = FXCollections.observableArrayList();
       
    }
    
    public void setBinding(ListChangeListener bind) {
    	myEventHandler = bind; 
    	myObservableList.addListener(myEventHandler); 
    }
    
    public void clear() {
    	myTextArea.clear();
    }
    
    public String getRecentCommand() {
    	return myObservableList.get(myObservableList.size()-1);
    }
    
    public ObservableList<String> getAllCommands() {
    	return myObservableList; 
    }
    
    public TextArea getTextArea() {
    	return myTextArea; 
    }
    
    public TextArea getHistory() {
        return myTextArea;
    }
    
    public void addHistory(String input) {
        myTextArea.appendText(input + "\n");
        myObservableList.add(input);
    }
}
