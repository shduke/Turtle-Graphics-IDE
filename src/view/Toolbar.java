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
	private ResourceBundle myResources;
    
	public Toolbar(String language) {
		super(language);
		myResources = ResourceBundle.getBundle(SlogoWindowView.DEFAULT_RESOURCE_PACKAGE + language);
		myResetHandler = new ResetEvent();
		myHelpHandler = new HelpEvent();
	}
    
	public HBox getToolbar() {
		HBox result = new HBox();
		result.getChildren().add(makeButton("ResetButton", myResetHandler));
		result.getChildren().add(makeButton("HelpButton", myHelpHandler));
		return result;
	}
    
	private class ResetEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			SlogoWindowView.myHistory.clear();
			InputField.myTextField.clear();
			SlogoWindowView.myVC.clear();
		}
	}
	
	private class HelpEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			HelpWindow display = new HelpWindow();
			Stage helpStage = new Stage();
			helpStage.setTitle(myResources.getString("HelpButton"));
			helpStage.setScene(display.getScene());
			helpStage.show();
		}
	}

}
