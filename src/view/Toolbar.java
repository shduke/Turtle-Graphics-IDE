package view;

import java.io.File;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import view.window.BackgroundColorWindow;
import view.window.ChooseLanguageWindow;
import view.window.HelpWindow;
import view.window.PenColorWindow;


/**
 * @author Noel Moon (nm142)
 *
 */
public class Toolbar extends HorizontalGUIObject {

	private EventHandler<ActionEvent> myResetHandler;
	private EventHandler<ActionEvent> myHelpHandler;
	private EventHandler<ActionEvent> myBackgroundHandler;
	private EventHandler<ActionEvent> myCursorImageHandler;
	private EventHandler<ActionEvent> myPenColorHandler;
	private ResourceBundle myResources;
	private HBox myHBox;
    
	private EventHandler<ActionEvent> myFileChooseHandler;
	
	public Toolbar(String language, EventHandler<ActionEvent> resetHandler, EventHandler<ActionEvent> fileChooseHandler) {
		super(language);
		myResources = ResourceBundle.getBundle(SlogoWindowView.DEFAULT_RESOURCE_PACKAGE + language);
		myResetHandler = resetHandler;
		
		myCursorImageHandler = fileChooseHandler;
		
		addButtons();
		
		
	}
    
	public HBox getToolbar() {
		return myHBox;
	}
	
	private void addButtons() {
		myHelpHandler = new HelpEvent();
		myBackgroundHandler = new BackgroundEvent();
		//myCursorImageHandler = new CursorImageEvent();
		myPenColorHandler = new PenColorEvent();
		
		myHBox = new HBox();
		myHBox.getChildren().add(makeButton("ResetButton", myResetHandler));
		myHBox.getChildren().add(makeButton("HelpButton", myHelpHandler));
		myHBox.getChildren().add(makeButton("BackgroundButton", myBackgroundHandler));
		myHBox.getChildren().add(makeButton("CursorImageButton", myCursorImageHandler));
		myHBox.getChildren().add(makeButton("PenColorButton", myPenColorHandler));
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
			BackgroundColorWindow window = new BackgroundColorWindow();
			window.start();
		}
	}
	
	private class PenColorEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			PenColorWindow window = new PenColorWindow();
			window.start();
		}
	}

}
