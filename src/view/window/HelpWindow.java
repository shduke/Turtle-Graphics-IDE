package view.window;

import java.awt.Dimension;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import view.AppResources;

/**
 * @author Noel Moon (nm142)
 *
 */
public class HelpWindow implements Window {

	public static final Dimension DEFAULT_SIZE = new Dimension(1000, 700);
	
	private Scene myScene;
	
	public HelpWindow() {
		BorderPane root = new BorderPane();
		root.setCenter(makePageDisplay());
		myScene = new Scene(root, DEFAULT_SIZE.getWidth(), DEFAULT_SIZE.getHeight());
	}
	
	private Node makePageDisplay() {
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load(AppResources.SLOGO_COMMANDS_URL.getResource());
        
		ErrorMessageWindow error = new ErrorMessageWindow(AppResources.DEFAULT_ERROR_MESSAGE.getResource());
		error.getScene();
		
		return browser;
	}
	
	public Scene getScene() {
		return myScene;
	}

	
}
