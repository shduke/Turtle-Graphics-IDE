package view.slogoWindowElements;

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
import view.slogoWindowElements.toolbarElements.HelpWindow;
import view.slogoWindowElements.toolbarElements.IProperty;
import view.slogoWindowElements.toolbarElements.PenColorProperty;
import view.slogoWindowElements.toolbarElements.PenPropertiesProperty;


/**
 * @author Noel Moon (nm142)
 *
 */
public class Toolbar implements IToolbar {

	private EventHandler<ActionEvent> myResetHandler;
	private EventHandler<ActionEvent> myNewWindowHandler;
	private EventHandler<ActionEvent> myHelpHandler;
	private EventHandler<ActionEvent> myBackgroundHandler;
	private EventHandler<ActionEvent> myCursorImageHandler;
	private EventHandler<ActionEvent> myPenColorHandler;
	private EventHandler<ActionEvent> myPenPropertiesHandler;
	private ComboBox<String> myBackgroundColorComboBox;
	private ComboBox<String> myPenColorComboBox;
	private VBox myPenPropertiesVBox;
	private ResourceBundle myResources;
	private String myLanguage;
	private HBox myHBox;
	
	public Toolbar(String language, EventHandler<ActionEvent> resetHandler, EventHandler<ActionEvent> fileChooseHandler, 
			ComboBox<String> backgroundColor, ComboBox<String> penColor, VBox penProperties) {
		myLanguage = language;
		myResources = ResourceBundle.getBundle(SlogoWindowView.DEFAULT_RESOURCE_PACKAGE + language);
		myResetHandler = resetHandler;
		myCursorImageHandler = fileChooseHandler;
		myBackgroundColorComboBox = backgroundColor;
		myPenColorComboBox = penColor;
		myPenPropertiesVBox = penProperties;
		addButtons();
	}
    
	public HBox getToolbar() {
		return myHBox;
	}
	
	private void addButtons() {
		myNewWindowHandler = new NewWindowEvent();
		myHelpHandler = new HelpEvent();
		myBackgroundHandler = new BackgroundEvent();
		myPenColorHandler = new PenColorEvent();
		myPenPropertiesHandler = new PenPropertiesEvent();
		
		myHBox = new HBox();
		//myHBox.getChildren().add(makeButton("ResetButton", myResetHandler));
		myHBox.getChildren().add(makeButton("NewWindowButton", myNewWindowHandler));
		myHBox.getChildren().add(makeButton("BackgroundButton", myBackgroundHandler));
		myHBox.getChildren().add(makeButton("CursorImageButton", myCursorImageHandler));
		//myHBox.getChildren().add(makeButton("PenColorButton", myPenColorHandler));
		myHBox.getChildren().add(makeButton("PenPropertiesButton", myPenPropertiesHandler));
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
	
	private class PenColorEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			IProperty window = new PenColorProperty(myPenColorComboBox);
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

}
