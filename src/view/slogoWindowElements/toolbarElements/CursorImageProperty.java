package view.slogoWindowElements.toolbarElements;

import java.awt.Dimension;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.stage.FileChooser;

/**
 * @author Noel Moon (nm142)
 *
 * Citation: http://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm
 */
public class CursorImageProperty extends Property {
	
	public static final Dimension DEFAULT_SIZE = new Dimension(200, 100);
	public static final String IMAGE_DIRECTORY = "./src/images";
	public static final String TITLE = "Choose Image File";
	
	private FileChooser myFileChooser;
	private File myFile;

	public CursorImageProperty() {
		super(DEFAULT_SIZE.getWidth(), DEFAULT_SIZE.getHeight());
		myFileChooser = new FileChooser();
		myFileChooser.setTitle(TITLE);
		myFile = myFileChooser.showOpenDialog(getStage());
	}
	
	public String getFileDirectory() {
		return myFile.getAbsolutePath();
	}
	
	private File getInitialDirectory(){
		Path dataDirectory = Paths.get(IMAGE_DIRECTORY);
		if (Files.exists(dataDirectory, LinkOption.NOFOLLOW_LINKS)){
			return new File(IMAGE_DIRECTORY);
		}else{
			return new File(".");
		}
	}
}
