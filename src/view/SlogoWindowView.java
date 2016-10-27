package view;

import java.util.ResourceBundle;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.InputField;
import view.window.Window;

/**
 * @author Noel Moon (nm142)
 * @author John Martin (jfm41)
 *
 */
public class SlogoWindowView implements Window {
    private static final double myAppWidth = AppResources.APP_WIDTH.getDoubleResource();
	private static final double myAppHeight = AppResources.APP_HEIGHT.getDoubleResource();;
    
    protected String myLanguage;
    private Scene myScene;
    private ResourceBundle myCommands;
    private InputField myInputField;
    public static VariablesAndCommands myVC;
    public static History myHistory;
    
    private Display myTurtleDisplay;
    private EventHandler<ActionEvent> myResetHandler;
    private EventHandler<ActionEvent> myFileChooseHandler;

    
    public SlogoWindowView(String language, EventHandler<ActionEvent> fileChooseEvent){
    	myFileChooseHandler = fileChooseEvent;
    	myResetHandler = new ResetEvent();
        myLanguage = language;
        myCommands = initResourceBundle(language);
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
    
    public History getHistory(){
    	return myHistory;
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
    
    public static Double getAppWidth(){
    	return myAppWidth;
    }
    
    public static Double getAppHeight(){
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
    
    private Node makeToolbar () {
    	Toolbar toolbar = new Toolbar(myLanguage, myResetHandler, myFileChooseHandler);
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
    	myVC.addVariable("x", "1");
    	myVC.addVariable("x", "2");
    	myVC.addVariable("y", "fheio");
    	myVC.addVariable("x", "sfioj");
    	myVC.addCommand("command5");
    	myVC.addCommand("command3");
    	return myVC.getTextArea();
    }

    private Node makeInputField() {
        myInputField = new InputField(myLanguage);
        return myInputField.getInputField();
    }
    
    private ResourceBundle initResourceBundle(String language){
        return ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
    }
    
}
