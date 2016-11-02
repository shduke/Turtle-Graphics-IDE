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
	
	private Scene myScene;
	private Stage myStage;
	private BorderPane myRoot;
	
	public Property(double width, double height) {
		myRoot = new BorderPane();
		myScene = new Scene(myRoot, width, height);
		myStage = new Stage();
	}
	
	public void setRoot(Node node) {
		myRoot.setCenter(node);
	}
	
	public void start() {
		myStage.setScene(getScene());
		myStage.show();
	}
	
	public void close() {
		myStage.close();
	}
	
	public void setTitle(String title) {
		myStage.setTitle(title);
	}
	
	public Scene getScene() {
		return myScene;
	}
	
	public Stage getStage() {
		return myStage;
	}
}
