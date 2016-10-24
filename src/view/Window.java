package view;

import javafx.scene.Scene;

/**
 * @author Noel Moon (nm142)
 * @author John Martin (jfm41)
 */
public interface Window {
	
	public static final String DEFAULT_RESOURCE_PACKAGE = "resources.languages/";

	public Scene getScene();

	public History getHistory();
	
	public void clearHistory();
	
	public Display getTurtleDisplay();

}
