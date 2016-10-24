package view;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


/**
 * @author Noel Moon (nm142)
 *
 */
public class Toolbar extends HorizontalGUIObject {

	private EventHandler<ActionEvent> myResetHandler;
	private EventHandler<ActionEvent> myHelpHandler;
	private EventHandler<ActionEvent> myLanguageHandler;
	private EventHandler<ActionEvent> myBackgroundHandler;
	private EventHandler<ActionEvent> myCursorImageHandler;
	private EventHandler<ActionEvent> myPenColorHandler;
	private ResourceBundle myResources;
	private HBox myHBox;
    
	public Toolbar(String language) {
		super(language);
		myResources = ResourceBundle.getBundle(SlogoWindowView.DEFAULT_RESOURCE_PACKAGE + language);
		addButtons();
	}
    
	public HBox getToolbar() {
		return myHBox;
	}
	
	private void addButtons() {
		myResetHandler = new ResetEvent();
		myHelpHandler = new HelpEvent();
		myLanguageHandler = new LanguageEvent();
		myBackgroundHandler = new BackgroundEvent();
		myCursorImageHandler = new CursorImageEvent();
		myPenColorHandler = new PenColorEvent();
		
		myHBox = new HBox();
		myHBox.getChildren().add(makeButton("ResetButton", myResetHandler));
		myHBox.getChildren().add(makeButton("HelpButton", myHelpHandler));
		//myHBox.getChildren().add(makeButton("LanguageButton", myLanguageHandler));
		myHBox.getChildren().add(makeButton("BackgroundButton", myBackgroundHandler));
		myHBox.getChildren().add(makeButton("CursorImageButton", myCursorImageHandler));
		myHBox.getChildren().add(makeButton("PenColorButton", myPenColorHandler));
	}
    
	private class ResetEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			SlogoWindowView.myHistory.clear();
			SlogoWindowView.myVC.clear();
			InputField.myTextArea.clear();
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
	
	private class LanguageEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			ChooseLanguageWindow window = new ChooseLanguageWindow();
			Stage stage = new Stage();
			stage.setTitle("Choose Language");
			stage.setScene(window.getScene());
			stage.show();
		}
	}
	
	private class BackgroundEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			
		}
	}
	
	private class CursorImageEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			
		}
	}
	
	private class PenColorEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			
		}
	}

}
