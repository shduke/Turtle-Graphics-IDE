package view.slogoWindowElements;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author Noel Moon
 * @author John Martin
 */
public class History implements IHistory {
    
    private TextArea myTextArea;
    private ListChangeListener myEventHandler;
    private ObservableList<String> myObservableList;
    private String myTurtlePosition;
    private String myTurtleDirection;
    private String myPenStatus;
    
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
    
    public VBox getHistory() {
        return makeHistory();
    }
    
    private VBox makeHistory() {
    	VBox vb = new VBox();
    	myTextArea.setPrefHeight(500);
    	vb.getChildren().add(myTextArea);
    	vb.getChildren().add(makeStatus("Turtle Position"));
    	vb.getChildren().add(makeStatus("Turtle Direction"));
    	vb.getChildren().add(makeStatus("Pen Status"));
    	return vb;
    }
    
    private HBox makeStatus(String statusName) {
    	HBox hb = new HBox();
    	Label statusLabel = new Label(statusName);
    	statusLabel.setPrefWidth(250);
    	hb.getChildren().add(statusLabel);
    	hb.getChildren().add(new Label("0"));
    	
    	return hb;
    }
    
    public void addHistory(String input) {
        myTextArea.appendText(input + "\n");
        myObservableList.add(input);
    }
    
    public void setTurtlePosition(int x, int y) {
    	String result = ("(" + x + ", " + y + ")");
    	myTurtlePosition = result;
    }
    
    public void setTurtleDirection(int direction) {
    	String result = Integer.toString(direction);
    	myTurtlePosition = result;
    }
    
    public void setPenStatus(String status) {
    	myTurtlePosition = status;
    }
}
