package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import view.slogoWindowElements.History;
import view.slogoWindowElements.IHistory;
import view.slogoWindowElements.IInputField;
import view.slogoWindowElements.IToolbar;
import view.slogoWindowElements.IVariablesAndCommands;
import view.slogoWindowElements.InputField;
import view.slogoWindowElements.Toolbar;
import view.slogoWindowElements.VariablesAndCommands;


/**
 * @author Noel Moon (nm142)
 * @author John Martin (jfm41)
 *
 */
public class SlogoWindowView implements ISlogoWindowView {
    public static final double myAppWidth = AppResources.APP_WIDTH.getDoubleResource();
	public static final double myAppHeight = AppResources.APP_HEIGHT.getDoubleResource();
	public static final String DEFAULT_RESOURCE_PACKAGE = "";
    
    private String myLanguage;
    private Scene myScene;
    private IHistory myHistory;
    private IInputField myInputField;
    private IVariablesAndCommands myVC;
    private Display myTurtleDisplay;
    private EventHandler<ActionEvent> myResetHandler;
    private EventHandler<ActionEvent> myFileChooseHandler;
    private ComboBox<String> myBackgroundColorComboBox;
    private ComboBox<String> myPenColorComboBox;
    
    public SlogoWindowView(String language, EventHandler<ActionEvent> fileChooseEvent){
    	myFileChooseHandler = fileChooseEvent;
    	myResetHandler = new ResetEvent();
        myLanguage = language;
        myBackgroundColorComboBox = makeBackgroundColorComboBox();
        myPenColorComboBox = makePenColorComboBox();
        BorderPane root = new BorderPane();
        root.setTop(makeToolbar());
        root.setRight(makeVarDisplay());
        root.setCenter(new Group(makeTurtleDisplay()));
        root.setLeft(makeHistory());
        root.setBottom(makeInputField());
        root.setId("root");
        myScene = new Scene(root, myAppWidth, myAppHeight);
        myScene.getStylesheets().add(getClass().getResource(AppResources.APP_CSS.getResource()).toExternalForm());
    }
    
    public IHistory getHistory(){
    	return myHistory;
    }
    
    public IVariablesAndCommands getVariablesAndCommands() {
    	return myVC;
    }
    
    public Scene getScene () {
        return myScene;
    }
    
    public Display getTurtleDisplay(){
    	return myTurtleDisplay;
    }
    
    public String getLanguage(){
    	return myLanguage; 
    }
    
    public Double getAppWidth(){
    	return myAppWidth;
    }
    
    public Double getAppHeight(){
    	return myAppHeight;
    }
    
    public void setHistoryBinding(ListChangeListener bind){
    	myHistory.setBinding(bind); 
    }
    
	private class ResetEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			myHistory.clear();
			myVC.clear();
			InputField.myTextArea.clear();
		}
	}
	
	private ComboBox<String> makeBackgroundColorComboBox() {
		myBackgroundColorComboBox = new ComboBox<String>();
		myBackgroundColorComboBox.getItems().addAll("WHITE", "BLUE", "RED", "GREEN", "YELLOW", "PINK", "PURPLE", "BLACK");
        myBackgroundColorComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	myTurtleDisplay.setBackgroundColor(Color.valueOf(newValue));
            }
        });
		return myBackgroundColorComboBox;
	}
	
	private ComboBox<String> makePenColorComboBox() {
		myPenColorComboBox = new ComboBox<String>();
		myPenColorComboBox.getItems().addAll("WHITE", "BLUE", "RED", "GREEN", "YELLOW", "PINK", "PURPLE", "BLACK");
        myPenColorComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	myTurtleDisplay.setPenColor(Color.valueOf(newValue));
            }
        });
		return myPenColorComboBox;
	}
    
    private Node makeToolbar () {
    	IToolbar toolbar = new Toolbar(myLanguage, myResetHandler, myFileChooseHandler, myBackgroundColorComboBox, myPenColorComboBox);
		return toolbar.getToolbar();
    }
    
    private Node makeHistory() {
        myHistory = new History();
        return myHistory.getHistory();
    }
    
    private Group makeTurtleDisplay() {
        myTurtleDisplay = new TurtleDisplay(null);
        return myTurtleDisplay.getGroup();
    }
    
    private Node makeVarDisplay() {
    	myVC = new VariablesAndCommands();
    	return myVC.getVCDisplay();
    }

    private Node makeInputField() {
        myInputField = new InputField(myLanguage, myHistory);
        return myInputField.getInputField();
    }
    
}
