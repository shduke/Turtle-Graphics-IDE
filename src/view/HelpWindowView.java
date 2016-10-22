package view;

import java.awt.Dimension;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * @author Noel Moon (nm142)
 *
 */
public class HelpWindowView implements WindowView {

	public static final Dimension DEFAULT_SIZE = new Dimension(1000, 700);
	
	private Scene myScene;
	
	public HelpWindowView() {
		BorderPane root = new BorderPane();
		root.setCenter(makePageDisplay());
		myScene = new Scene(root, DEFAULT_SIZE.getWidth(), DEFAULT_SIZE.getHeight());
	}
	
	private Node makePageDisplay() {
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load(AppResources.SLOGO_COMMANDS_URL.getResource());
        
		ErrorMessage error = new ErrorMessage(AppResources.DEFAULT_ERROR_MESSAGE.getResource());
		error.getScene();
		
		return browser;
	}
	
	@Override
	public Scene getScene() {
		return myScene;
	}

	
}
