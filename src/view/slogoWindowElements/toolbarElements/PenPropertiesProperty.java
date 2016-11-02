/**
 * 
 */
package view.slogoWindowElements.toolbarElements;

import java.awt.Dimension;

import javafx.scene.layout.VBox;

/**
 * @author Noel Moon (nm142)
 *
 */
public class PenPropertiesProperty extends Property {
	
	public static final Dimension DEFAULT_SIZE = new Dimension(200, 200);

	public PenPropertiesProperty(VBox vb) {
		super(DEFAULT_SIZE.getWidth(), DEFAULT_SIZE.getHeight());
		setTitle("Pen Properties");
		setRoot(vb);
	}
}
