package view.slogoWindowElements.toolbarElements;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;

/**
 * @author Noel Moon (nm142)
 *
 */
public class PenColorProperty extends Property {
	
	public PenColorProperty(ComboBox<String> penColor) {
		super();
		setRoot(penColor);
	}

}
