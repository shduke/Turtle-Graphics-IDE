/**
 * 
 */
package view.slogoWindowElements.toolbarElements;

import java.awt.Dimension;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Noel Moon (nm142)
 *
 */
public abstract class Property implements IProperty {

	public static final Dimension DEFAULT_SIZE = new Dimension(200, 100);
	
	private Scene myScene;
	private Stage myStage;
	private BorderPane myRoot;
	
	public Property() {
		myRoot = new BorderPane();
		myScene = new Scene(myRoot, DEFAULT_SIZE.getWidth(), DEFAULT_SIZE.getHeight());
	}
	
	public void setRoot(Node node) {
		myRoot.setCenter(node);
	}
	
	public void start() {
		myStage = new Stage();
		//myStage.setTitle("Choose Pen Color");
		myStage.setScene(getScene());
		myStage.show();
	}
	
	public void close() {
		myStage.close();
	}
	
	public Scene getScene() {
		return myScene;
	}
	
	public Stage getStage() {
		return myStage;
	}
}
