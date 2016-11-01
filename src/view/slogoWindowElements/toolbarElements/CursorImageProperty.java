package view.slogoWindowElements.toolbarElements;

import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author Noel Moon (nm142)
 *
 * Citation: http://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm
 */
public class CursorImageProperty extends Property {
	
	private FileChooser myFileChooser;

	public CursorImageProperty() {
		super();
		myFileChooser = new FileChooser();
		myFileChooser.setTitle("Choose Image File");
		myFileChooser.showOpenDialog(getStage());
	}
	
	
}
