package view;

import cursor.ICursorManagerDisplay;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import view.slogoWindowElements.History;
import view.slogoWindowElements.IHistory;
import view.slogoWindowElements.IInputField;
import view.slogoWindowElements.IToolbar;
import view.slogoWindowElements.IVariablesAndCommands;
import view.slogoWindowElements.InputField;
import view.slogoWindowElements.Toolbar;
import view.slogoWindowElements.VariablesAndCommands;
import view.slogoWindowElements.toolbarElements.CursorImageProperty;


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
    private EventHandler<ActionEvent> myFileChooserHandler;
    private ComboBox<String> myBackgroundColorComboBox;
    private ComboBox<String> myPenColorComboBox;
    private ComboBox<String> myPenThicknessComboBox;
    private ComboBox<String> myPenLineTypeComboBox;
    private VBox myPenPropertiesVBox;
    
    public SlogoWindowView(String language){
    	myFileChooserHandler = new FileChooserEvent();
    	myResetHandler = new ResetEvent();
        myLanguage = language;
        makeBackgroundColorComboBox();
        makePenPropertiesVBox();
        myScene = new Scene(makeRoot(), myAppWidth, myAppHeight);
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
			myInputField.clear();
		}
	}
	
	private class FileChooserEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			CursorImageProperty image = new CursorImageProperty();
			myTurtleDisplay.setTurtleImage(image.getFileDirectory());
			myTurtleDisplay.setTurtleImage("src/images/KTurtle_Turtle.png");
		}
	}
	
	private BorderPane makeRoot() {
		BorderPane root = new BorderPane();
        root.setTop(makeToolbar());
        root.setRight(makeVCDisplay());
        root.setCenter(new Group(makeTurtleDisplay()));
        root.setLeft(makeHistory());
        root.setBottom(makeInputField());
        root.setId("root");
        return root;
	}
	
	private void makeBackgroundColorComboBox() {
		myBackgroundColorComboBox = new ComboBox<String>();
		myBackgroundColorComboBox.getItems().addAll("WHITE", "BLUE", "RED", "GREEN", "YELLOW", "PINK", "PURPLE", "BLACK");
        myBackgroundColorComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	myTurtleDisplay.setBackgroundColor(Color.valueOf(newValue));
            }
        });
	}
	
	private void makePenColorComboBox() {
		myPenColorComboBox = new ComboBox<String>();
		myPenColorComboBox.getItems().addAll("WHITE", "BLUE", "RED", "GREEN", "YELLOW", "PINK", "PURPLE", "BLACK");
        myPenColorComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	myTurtleDisplay.setPenColor(Color.valueOf(newValue));
            }
        });
	}
	
	private void makePenThicknessComboBox() {
		myPenThicknessComboBox = new ComboBox<String>();
		myPenThicknessComboBox.getItems().addAll("THIN", "NORMAL", "THICK");
        myPenThicknessComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	myTurtleDisplay.setPenColor(Color.valueOf(newValue));
            }
        });
	}
	
	private void makePenLineTypeComboBox() {
		myPenLineTypeComboBox = new ComboBox<String>();
		myPenLineTypeComboBox.getItems().addAll("SOLID", "DASHED", "DOTTED");
        myPenLineTypeComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	myTurtleDisplay.setPenColor(Color.valueOf(newValue));
            }
        });
	}
	
	private void makePenPropertiesVBox() {
		makePenColorComboBox();
		makePenThicknessComboBox();
		makePenLineTypeComboBox();
		myPenPropertiesVBox = new VBox();
		myPenPropertiesVBox.getChildren().add(new Label("Pen Color"));
		myPenPropertiesVBox.getChildren().add(myPenColorComboBox);
		myPenPropertiesVBox.getChildren().add(new Label("\nThickness"));
		myPenPropertiesVBox.getChildren().add(myPenThicknessComboBox);
		myPenPropertiesVBox.getChildren().add(new Label("\nLine Type"));
		myPenPropertiesVBox.getChildren().add(myPenLineTypeComboBox);
	}
    
    private Node makeToolbar () {
    	IToolbar toolbar = new Toolbar(myLanguage, myFileChooserHandler, myBackgroundColorComboBox, myPenPropertiesVBox);
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
    
    private Node makeVCDisplay() {
    	myVC = new VariablesAndCommands();
    	return myVC.getVCDisplay();
    }

    private Node makeInputField() {
        myInputField = new InputField(myLanguage, myHistory);
        return myInputField.getInputField();
    }


	@Override
	public void updateInformation(ICursorManagerDisplay myCursorManager) {
		// TODO Auto-generated method stub
		myTurtleDisplay.addDrawables(myCursorManager.getDrawableItems());		
	}
    
}
