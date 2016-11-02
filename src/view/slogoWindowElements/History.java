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
import view.ITurtleSelector;

/**
 * @author Noel Moon
 * @author John Martin
 */
public class History implements IHistory, ITurtleSelector {
    
    private TextArea myTextArea;
    private ListChangeListener myEventHandler;
    private ObservableList<String> myObservableList;
    private Label myTurtlePosition;
    private Label myTurtleDirection;
    private Label myVisibleStatus;
    private HBox myPositionBox;
    private HBox myDirectionBox;
    private HBox myVisibleBox;
    
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
    	vb.getChildren().add(makePositionBox());
    	vb.getChildren().add(makeDirectionBox());
    	vb.getChildren().add(makeVisibleBox());
    	return vb;
    }
    
    private HBox makeStatus(String statusName, HBox hb, Label lb) {
    	Label statusLabel = new Label(statusName);
    	statusLabel.setPrefWidth(140);
    	hb.getChildren().add(statusLabel);
    	hb.getChildren().add(lb);
    	return hb;
    }
    
    private HBox makePositionBox(){
    	myPositionBox = new HBox();
    	myTurtlePosition = new Label("(0, 0)");
    	makeStatus("Pos: ", myPositionBox, myTurtlePosition);
    	return myPositionBox;
    }
    
    private HBox makeDirectionBox(){
    	myDirectionBox = new HBox();
        myTurtleDirection = new Label("0");
    	makeStatus("Ori: ", myDirectionBox, myTurtleDirection);
    	return myDirectionBox;
    }
    
    private HBox makeVisibleBox(){
    	myVisibleBox = new HBox();
    	myVisibleStatus = new Label("false");
    	makeStatus("Vis: ", myVisibleBox, myVisibleStatus);
    	return myVisibleBox;
    }
    
    public void addHistory(String input) {
        myTextArea.appendText(input + "\n");
        myObservableList.add(input);
    }
    
    public void setTurtlePosition(double x, double y) {
    	String result = ("(" + x + ", " + y + ")");
    	myTurtlePosition.setText(result);;
    }
    
    public void setTurtleDirection(double direction) {
    	String result = Double.toString(direction);
    	myTurtleDirection.setText(result);;
    }
    
    public void setVisibleStatus(String status) {
    	myVisibleStatus.setText(status);
    }

	@Override
	public void selectTurtle(double x, double y, double orientation, boolean isVisible) {
		setTurtlePosition(x, y);
		setTurtleDirection(orientation);
		setVisibleStatus(Boolean.toString(isVisible));		
	}
}
