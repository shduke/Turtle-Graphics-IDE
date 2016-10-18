package view;

import java.awt.Dimension;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class SlogoView {
    public static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/";
    public static final Dimension DEFAULT_SIZE = new Dimension(1000, 650);
    
    private Scene myScene;
    private ResourceBundle resourceBundle;
    private String language;
    
    public SlogoView(String language){
        this.language = language;
        this.resourceBundle = initResourceBundle(language);
        BorderPane root = new BorderPane();
        root.setTop(makeToolbar());
        root.setLeft(makeHistory());
        root.setRight(makeTurtleDisplay());
        root.setBottom(makeInputField());
        myScene = new Scene(root, DEFAULT_SIZE.getWidth(), DEFAULT_SIZE.getHeight());
    }
    
    private Node makeToolbar () {
        Label label = new Label("Toolbar");
        return label;
    }
    
    private Node makeHistory() {
        return new Label("History");
    }
    
    private Node makeTurtleDisplay() {
        return new Label("Turtle Display");
    }

    private Node makeInputField() {
        return new InputField(language);
    }
    
    private ResourceBundle initResourceBundle(String language){
        return ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
    }
    
    public Scene getScene () {
        return myScene;
    }
    
}
