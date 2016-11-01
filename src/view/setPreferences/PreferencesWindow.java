package view.setPreferences;

import java.awt.Dimension;
import java.util.ResourceBundle;

import controller.SlogoController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.AppResources;
import view.SlogoWindowView;

public class PreferencesWindow {

	public static final double myAppWidth = AppResources.APP_WIDTH.getDoubleResource();
	public static final double myAppHeight = AppResources.APP_HEIGHT.getDoubleResource();
	public static final Dimension DEFAULT_SIZE = new Dimension(300, 100);
    
    private String myLanguage;
    private Scene myScene;
	private Stage stage;

	private double elementHeights = 30;
	private double elementWidths = DEFAULT_SIZE.getWidth()/2;
	
	// Choose Background Preference
	private ComboBox<String> myBGComboBox = new ComboBox<String>();;
	private String myBackground;
	
	// NumTurtles TextArea
	private TextArea myNumTurtles;
	
	// File Selection HBox
	private HBox filesHBox;
	
	// Advance Button
	private EventHandler<ActionEvent> myAdvanceHandler;
	private Button myAdvanceButton;
	
//    private IStartImage myStartImage;
//    private ILoadFile myLoadFile;
   
    
    public PreferencesWindow(){
    	myAdvanceHandler = new AdvanceEvent();
    	BorderPane root = new BorderPane();
    	makeAdvanceButton();
    	makeChooseBG();
    	makeSetNumTurtles();
    	makeFileSelectionButtons();
    	
    	root.setLeft(myBGComboBox);
    	BorderPane.setAlignment(myBGComboBox, Pos.CENTER);
    	root.setBottom(myAdvanceButton);
    	BorderPane.setAlignment(myAdvanceButton, Pos.CENTER);
    	root.setRight(myNumTurtles);
    	BorderPane.setAlignment(myNumTurtles, Pos.CENTER);
    	root.setTop(filesHBox);
    	BorderPane.setAlignment(filesHBox, Pos.CENTER);
		myScene = new Scene(root, DEFAULT_SIZE.getWidth(), DEFAULT_SIZE.getHeight());
    }
    
    public void start(){
    	stage = new Stage();
		stage.setTitle("Set Preferences");
		stage.setScene(getScene());
		stage.show();
    }
    
    private ComboBox<String> makeChooseBG() {
    	myBGComboBox.getItems().addAll("White", "Blue", "Green", "Red");
    	myBGComboBox.setMinWidth(elementWidths);
    	myBGComboBox.setMaxWidth(elementWidths);
    	myBGComboBox.setMinHeight(elementHeights);
    	myBGComboBox.setMaxHeight(elementHeights);
    	myBGComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	myLanguage = newValue;               
            }
        });
    	return myBGComboBox;
	}
    
    private TextArea makeSetNumTurtles() {
    	myNumTurtles = new TextArea();
    	myNumTurtles.setMinWidth(elementWidths);
    	myNumTurtles.setMaxWidth(elementWidths);
    	myNumTurtles.setMinHeight(elementHeights);
    	myNumTurtles.setMaxHeight(elementHeights);
		return myNumTurtles;
	}
    
    private HBox makeAdvanceButton() {
    	myAdvanceButton = new Button();
    	String label = "Advance";
    	myAdvanceButton.setText(label);
    	myAdvanceButton.setOnAction(myAdvanceHandler);
    	myAdvanceButton.setMinWidth(2*elementWidths);
    	myAdvanceButton.setMaxWidth(2*elementWidths);
    	myAdvanceButton.setMinHeight(elementHeights);
    	myAdvanceButton.setMaxHeight(elementHeights);
    	
    	HBox advanceHBox = new HBox();
    	advanceHBox.getChildren().add(myAdvanceButton);
    	
    	return advanceHBox;
	}
    
    private HBox makeFileSelectionButtons(){
    	ImageChooserEvent imageChooseHandler = new ImageChooserEvent();
    	Button imageSelectButton = new Button();
    	String imageLabel = "Select Cursor Image";
    	imageSelectButton.setText(imageLabel);
    	imageSelectButton.setOnAction(imageChooseHandler);
    	imageSelectButton.setMinWidth(elementWidths);
    	imageSelectButton.setMaxWidth(elementWidths);
    	imageSelectButton.setMinHeight(elementHeights);
    	imageSelectButton.setMaxHeight(elementHeights);
    	
    	FileChooserEvent fileChooseHandler = new FileChooserEvent();
    	Button fileSelectButton = new Button();
    	String fileLabel = "Load File";
    	fileSelectButton.setText(fileLabel);
    	fileSelectButton.setOnAction(fileChooseHandler);
    	fileSelectButton.setMinWidth(elementWidths);
    	fileSelectButton.setMaxWidth(elementWidths);
    	fileSelectButton.setMinHeight(elementHeights);
    	fileSelectButton.setMaxHeight(elementHeights);
    	
    	filesHBox = new HBox();
    	filesHBox.getChildren().add(imageSelectButton);
    	filesHBox.getChildren().add(fileSelectButton);
    	filesHBox.setAlignment(Pos.CENTER);
    	return filesHBox;
    }
    
    public void close() {
		stage.close();
	}
    
    public Scene getScene () {
        return myScene;
    }
    
    public String getLanguage(){
    	return myLanguage; 
    }
    
    private class AdvanceEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			String stringNumTurtles = myNumTurtles.getText();
			boolean errorCaught = false;
			try {
				Integer.parseInt(stringNumTurtles);
			} catch (Exception e){
				errorCaught = true;
			}
			// TODO: refactor to an error popup
			if (!errorCaught){
				// Proceed to slogo
			}
		}
	}
    
    private class ImageChooserEvent implements EventHandler<ActionEvent> {
		private FileChooser imageChooser;
		
		@Override
		public void handle(ActionEvent event) {
			imageChooser = new FileChooser();
			imageChooser.setTitle("Open Resource File");
			imageChooser.showOpenDialog(stage);
		}
	}
    
    private class FileChooserEvent implements EventHandler<ActionEvent> {
		private FileChooser fileChooser;
		
		@Override
		public void handle(ActionEvent event) {
			fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			fileChooser.showOpenDialog(stage);
		}
	}
    
}
