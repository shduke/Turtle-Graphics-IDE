package view;

import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import view.InputField;

/**
 * @author Noel Moon
 * @author John Martin
 *
 */
public class SlogoView {
    public static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/";
    private static final double myAppWidth = AppResources.APP_WIDTH.getDoubleResource();
	private static final double myAppHeight = AppResources.APP_HEIGHT.getDoubleResource();;
    
    protected String myLanguage;
    private Scene myScene;
    private ResourceBundle myCommands;
    private InputField myInputField;
    protected static History myHistory;
    
    //TODO: make turtledisplay private
    public static TurtleDisplay myTurtleDisplay;
    
    public SlogoView(String language){
        myLanguage = language;
        myCommands = initResourceBundle(language);
        BorderPane root = new BorderPane();
        root.setTop(makeToolbar());
        root.setRight(makeTurtleDisplay());
        root.setLeft(makeHistory());
        root.setBottom(makeInputField());
        root.setId("root");
        myScene = new Scene(root, myAppWidth, myAppHeight);
        myScene.getStylesheets().add(getClass().getResource(AppResources.APP_CSS.getResource()).toExternalForm());
    }
    
    private Node makeToolbar () {
        Label label = new Label("Toolbar");
        return label;
    }
    
    private Node makeHistory() {
        myHistory = new History(null);
        return myHistory.getHistory();
    }
    
    private Node makeTurtleDisplay() {
        myTurtleDisplay = new TurtleDisplay(null);
        return myTurtleDisplay.getStackPane();
    }

    private Node makeInputField() {
        myInputField = new InputField(myLanguage);
        return myInputField.getInputField();
    }
    
    private ResourceBundle initResourceBundle(String language){
        return ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
    }
    
    public Scene getScene () {
        return myScene;
    }
    
    public TurtleDisplay getTurtleDisplay(){
    	return myTurtleDisplay;
    }
    
    public static Double getAppWidth(){
    	return myAppWidth;
    }
    
    public static Double getAppHeight(){
    	return myAppHeight;
    }
    
}
