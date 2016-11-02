package view.slogoWindowElements.toolbarElements;


import java.awt.Dimension;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

/**
 * @author Noel Moon (nm142)
 *
 */
public class PenColorProperty extends Property {
	public static final Dimension DEFAULT_SIZE = new Dimension(200, 100);
	
	public PenColorProperty(ComboBox<String> penColor) {
		super(DEFAULT_SIZE.getWidth(), DEFAULT_SIZE.getHeight());
		setRoot(penColor);
	}

}
