package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import view.InputField;

/**
 * @author Noel Moon
 *
 */
public class SlogoView {
    public static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/";
    public static final Dimension DEFAULT_SIZE = new Dimension(1200, 650);
    
    protected String myLanguage;
    private Scene myScene;
    private ResourceBundle myResources;
    private InputField myInputField;
    protected static History myHistory;
    
    public SlogoView(String language){
        this.myLanguage = language;
        this.myResources = initResourceBundle(language);
        BorderPane root = new BorderPane();
        root.setTop(makeToolbar());
        root.setRight(makeTurtleDisplay());
        root.setLeft(makeHistory());
        root.setBottom(makeInputField());
        myScene = new Scene(root, DEFAULT_SIZE.getWidth(), DEFAULT_SIZE.getHeight());
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
        StackPane sp = new StackPane();
        Canvas canvas = new Canvas(800, 400);
        sp.setStyle("-fx-background-color: linen");
        sp.getChildren().add(canvas);
        return sp;
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
    
}
