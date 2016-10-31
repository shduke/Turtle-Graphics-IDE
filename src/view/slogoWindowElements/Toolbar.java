package view.slogoWindowElements;

import java.util.ResourceBundle;

import controller.SlogoController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import view.SlogoWindowView;
import view.slogoWindowElements.toolbarElements.BackgroundColorWindow;
import view.slogoWindowElements.toolbarElements.HelpWindow;
import view.slogoWindowElements.toolbarElements.PenColorWindow;


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
	private ResourceBundle myResources;
	private String myLanguage;
	private HBox myHBox;
	
	public Toolbar(String language, EventHandler<ActionEvent> resetHandler, EventHandler<ActionEvent> fileChooseHandler) {
		myLanguage = language;
		myResources = ResourceBundle.getBundle(SlogoWindowView.DEFAULT_RESOURCE_PACKAGE + language);
		myResetHandler = resetHandler;
		myCursorImageHandler = fileChooseHandler;
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
		
		myHBox = new HBox();
		myHBox.getChildren().add(makeButton("ResetButton", myResetHandler));
		myHBox.getChildren().add(makeButton("NewWindowButton", myNewWindowHandler));
		myHBox.getChildren().add(makeButton("BackgroundButton", myBackgroundHandler));
		myHBox.getChildren().add(makeButton("CursorImageButton", myCursorImageHandler));
		myHBox.getChildren().add(makeButton("PenColorButton", myPenColorHandler));
		myHBox.getChildren().add(makeButton("HelpButton", myHelpHandler));
	}
	
	private class NewWindowEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Stage slogoStage = new Stage();
        	SlogoWindowView display = new SlogoWindowView(myLanguage, null);
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
	
    private Button makeButton (String property, EventHandler<ActionEvent> handler) {
        Button result = new Button();
        String label = myResources.getString(property);
        result.setText(label);
        result.setOnAction(handler);
        return result;
    }

}
