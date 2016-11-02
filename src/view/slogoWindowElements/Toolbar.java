package view.slogoWindowElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import controller.SlogoController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.SlogoWindowView;
import view.slogoWindowElements.toolbarElements.BackgroundColorProperty;
import view.slogoWindowElements.toolbarElements.ColorPalette;
import view.slogoWindowElements.toolbarElements.HelpWindow;
import view.slogoWindowElements.toolbarElements.IProperty;
import view.slogoWindowElements.toolbarElements.ImagePalette;
import view.slogoWindowElements.toolbarElements.PenColorProperty;
import view.slogoWindowElements.toolbarElements.PenPropertiesProperty;


/**
 * @author Noel Moon (nm142)
 *
 */
public class Toolbar implements IToolbar {

	private EventHandler<ActionEvent> myNewWindowHandler;
	private EventHandler<ActionEvent> myHelpHandler;
	private EventHandler<ActionEvent> myBackgroundHandler;
	private EventHandler<ActionEvent> myCursorImageHandler;
	private EventHandler<ActionEvent> myPenPropertiesHandler;
	private EventHandler<ActionEvent> myColorPaletteHandler;
	private EventHandler<ActionEvent> myImagePaletteHandler;
	
	private ComboBox<String> myBackgroundColorComboBox;
	private VBox myPenPropertiesVBox;
	private HBox myColorPaletteHBox;
	private HBox myImagePaletteHBox;
	private ResourceBundle myResources;
	private String myLanguage;
	private HBox myHBox;
	
	public Toolbar(String language, EventHandler<ActionEvent> fileChooseHandler, ComboBox<String> backgroundColor, VBox penProperties) {
		myLanguage = language;
		myResources = ResourceBundle.getBundle(SlogoWindowView.DEFAULT_RESOURCE_PACKAGE + language);
		myCursorImageHandler = fileChooseHandler;
		myBackgroundColorComboBox = backgroundColor;
		myPenPropertiesVBox = penProperties;
		myColorPaletteHandler = new ColorPaletteEvent();
		myImagePaletteHandler = new ImagePaletteEvent();
		addButtons();
	}
    
	public HBox getToolbar() {
		return myHBox;
	}
	
	private void addButtons() {
		myNewWindowHandler = new NewWindowEvent();
		myHelpHandler = new HelpEvent();
		myBackgroundHandler = new BackgroundEvent();
		myPenPropertiesHandler = new PenPropertiesEvent();
		
		myHBox = new HBox();
		myHBox.getChildren().add(makeButton("NewWindowButton", myNewWindowHandler));
		myHBox.getChildren().add(makeButton("BackgroundButton", myBackgroundHandler));
		myHBox.getChildren().add(makeButton("CursorImageButton", myCursorImageHandler));
		myHBox.getChildren().add(makeButton("PenPropertiesButton", myPenPropertiesHandler));
		myHBox.getChildren().add(makeButton("ColorPaletteButton", myColorPaletteHandler));
		myHBox.getChildren().add(makeButton("ImagePaletteButton", myImagePaletteHandler));
		myHBox.getChildren().add(makeButton("HelpButton", myHelpHandler));
	}
	
    private Button makeButton (String property, EventHandler<ActionEvent> handler) {
        Button result = new Button();
        String label = myResources.getString(property);
        result.setText(label);
        result.setOnAction(handler);
        return result;
    }
	
	private class NewWindowEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Stage slogoStage = new Stage();
        	SlogoWindowView display = new SlogoWindowView(myLanguage);
            slogoStage.setTitle("SLogo");
            slogoStage.setScene(display.getScene());
            slogoStage.show();
            SlogoController slogo = new SlogoController(display);
		}
	}
	
	private class HelpEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			HelpWindow window = new HelpWindow();
			Stage stage = new Stage();
			stage.setTitle(myResources.getString("HelpButton"));
			stage.setScene(window.getScene());
			stage.show();
		}
	}
	
	private class BackgroundEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			IProperty window = new BackgroundColorProperty(myBackgroundColorComboBox);
			window.start();
		}
	}
	
	private class PenPropertiesEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			IProperty window = new PenPropertiesProperty(myPenPropertiesVBox);
			window.start();
		}
	}
	
	private class ColorPaletteEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			List<String> list = new ArrayList<String>();
			list.addAll(Arrays.asList("BLACK", "WHITE", "BLUE", "RED", "YELLOW"));
			IProperty window = new ColorPalette(list);
			window.start();
		}
	}
	
	private class ImagePaletteEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			List<String> list = new ArrayList<String>();
			list.addAll(Arrays.asList("src/images/turtle.png", "src/images/-1EaCVVK.jpg", "src/images/KTurtle_Turtle.png",  
					"src/images/KTurtle_Turtle.png", "src/images/KTurtle_Turtle.png"));
			IProperty window = new ImagePalette(list);
			window.start();
		}
	}

}
