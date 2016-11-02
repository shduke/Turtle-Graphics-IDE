package view.slogoWindowElements.toolbarElements;

import javafx.scene.control.ComboBox;

/**
 * @author Noel Moon (nm142)
 *
 */
public class BackgroundColorProperty extends Property {	
	
	public BackgroundColorProperty(ComboBox<String> backgroundColor) {
		super();
		setTitle("Set Background Color");
		setRoot(backgroundColor);

	}

}
