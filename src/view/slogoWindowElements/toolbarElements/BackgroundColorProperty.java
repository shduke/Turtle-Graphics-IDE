package view.slogoWindowElements.toolbarElements;

import java.awt.Dimension;

import javafx.scene.control.ComboBox;

/**
 * @author Noel Moon (nm142)
 *
 */
public class BackgroundColorProperty extends Property {	
	
	public static final Dimension DEFAULT_SIZE = new Dimension(200, 100);
	
	public BackgroundColorProperty(ComboBox<String> backgroundColor) {
		super(DEFAULT_SIZE.getWidth(), DEFAULT_SIZE.getHeight());
		setTitle("Set Background Color");
		setRoot(backgroundColor);

	}

}
