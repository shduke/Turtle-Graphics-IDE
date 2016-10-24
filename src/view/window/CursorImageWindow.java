package view.window;

import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author Noel Moon (nm142)
 *
 * Citation: http://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm
 */
public class CursorImageWindow implements Window {
	
	private Scene myScene;
	private FileChooser myFileChooser;
	private Stage myStage;

	public CursorImageWindow(Stage stage) {
		myFileChooser = new FileChooser();
		myFileChooser.setTitle("Choose Image File");
		myFileChooser.showOpenDialog(stage);
	}

	@Override
	public Scene getScene() {
		return myScene;
	}
	
	public void start() {
		myStage = new Stage();
		myStage.setTitle("Choose Cursor Image");
		myStage.setScene(getScene());
		myStage.show();
	}
	
	public void close() {
		myStage.close();
	}
	
	
}
