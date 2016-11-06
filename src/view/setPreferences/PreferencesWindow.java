package view.setPreferences;

import java.awt.Dimension;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

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
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.AppResources;
import view.SlogoWindowView;

// TODO: Make compatible with language

/**
 * @author John Martin
 *
 */
public class PreferencesWindow {

	public static final double myAppWidth = AppResources.APP_WIDTH.getDoubleResource();
	public static final double myAppHeight = AppResources.APP_HEIGHT.getDoubleResource();
	public static final Dimension DEFAULT_SIZE = new Dimension(300, 100);
	
	public static final String IMAGE_DIRECTORY = "./src/images";
    
    private String myLanguage;
    private Scene myScene;
	private Stage stage;
	private Stage slogoStage;

	private double elementHeights = 30;
	private double elementWidths = DEFAULT_SIZE.getWidth()/2;
	
	// Choose Background Preference
	private ComboBox<String> myBGComboBox = new ComboBox<String>();;
	private Color myBackgroundColor = Color.LIGHTGRAY;
	
	// NumTurtles TextArea
	private TextArea myNumTurtles;
	private int initNumTurtles;
	
	// File Selection HBox
	private HBox filesHBox;
	
	// Advance Button
	private EventHandler<ActionEvent> myAdvanceHandler;
	private Button myAdvanceButton;
	
	// Image Chooser
	private File myImageFile;
	private boolean imageChanged = false;
		
//    private IStartImage myStartImage;
//    private ILoadFile myLoadFile;
   
    
    public PreferencesWindow(String language){
    	myLanguage = language;
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
    	myBGComboBox.setValue("DEFAULT");
    	myBGComboBox.getItems().addAll("WHITE", "BLUE", "RED", "GREEN", "YELLOW", "PINK", "PURPLE", "BLACK");
    	myBGComboBox.setMinWidth(elementWidths);
    	myBGComboBox.setMaxWidth(elementWidths);
    	myBGComboBox.setMinHeight(elementHeights);
    	myBGComboBox.setMaxHeight(elementHeights);
    	myBGComboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            	myBackgroundColor = Color.valueOf(newValue);
            }
        });
    	return myBGComboBox;
	}
    
    private TextArea makeSetNumTurtles() {
    	myNumTurtles = new TextArea();
    	myNumTurtles.setText("Num. Turtles");
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
    	Button imageSelectButton = makeFileButton(imageChooseHandler, "Select Cursor Image");
    	
    	FileChooserEvent fileChooseHandler = new FileChooserEvent();
    	Button fileSelectButton = makeFileButton(fileChooseHandler, "Load File");
    	
    	filesHBox = new HBox();
    	filesHBox.getChildren().add(imageSelectButton);
    	filesHBox.getChildren().add(fileSelectButton);
    	filesHBox.setAlignment(Pos.CENTER);
    	return filesHBox;
    }
    
    private Button makeFileButton(EventHandler<ActionEvent> handler, String label){
    	Button newButton = new Button();
    	newButton.setText(label);
    	newButton.setOnAction(handler);
    	newButton.setMinWidth(elementWidths);
    	newButton.setMaxWidth(elementWidths);
    	newButton.setMinHeight(elementHeights);
    	newButton.setMaxHeight(elementHeights);
    	return newButton;
    }
    
    private void setNumTurtles(){
    	String stringNumTurtles = myNumTurtles.getText();
		initNumTurtles = 1;
		try {
			if (stringNumTurtles.equals("Num. Turtles")){
				initNumTurtles = 1;
			} else {
				initNumTurtles = Integer.parseInt(stringNumTurtles);
			}
		} catch (Exception e){
			initNumTurtles = 1;
		}
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
			setNumTurtles();
			AppResources.INIT_NUM_TURTLES.setDoubleResource(initNumTurtles);
			AppResources.CANVAS_COLOUR.setColorResource(myBackgroundColor);
			if (imageChanged){
				AppResources.DEFAULT_TURTLE_IMAGE.setResource(getImageDirectory());
			}
			stage.close();
			slogoStage = new Stage();
        	SlogoWindowView display = new SlogoWindowView(myLanguage);
            slogoStage.setTitle("SLogo");
            slogoStage.setScene(display.getScene());
            slogoStage.show();
            SlogoController slogo = new SlogoController(display);
			
			
		}
	}
    
    private class ImageChooserEvent implements EventHandler<ActionEvent> {
		private FileChooser imageChooser;
		
		@Override
		public void handle(ActionEvent event) {
			imageChooser = new FileChooser();
			imageChooser.setTitle("Open Resource File");
//			imageChooser.setInitialDirectory(getInitialDirectory());
			myImageFile = imageChooser.showOpenDialog(stage);	
			imageChanged = true;
		}
	}

	public String getImageDirectory() {
		return myImageFile.getAbsolutePath();
	}
	
	private File getInitialDirectory(){
		Path dataDirectory = Paths.get(IMAGE_DIRECTORY);
		if (Files.exists(dataDirectory, LinkOption.NOFOLLOW_LINKS)){
			return new File(IMAGE_DIRECTORY);
		}else{
			return new File(".");
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
