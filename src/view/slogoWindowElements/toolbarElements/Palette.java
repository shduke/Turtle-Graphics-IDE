/**
 * 
 */
package view.slogoWindowElements.toolbarElements;

import java.awt.Dimension;
import java.util.List;

import javafx.scene.layout.HBox;

/**
 * @author Noel Moon (nm142)
 *
 */
public abstract class Palette extends Property {
	
	public static final Dimension DEFAULT_SIZE = new Dimension(800, 200);

	private List<?> myPalette;
	
	public Palette(HBox palette) {
		super(DEFAULT_SIZE.getWidth(), DEFAULT_SIZE.getHeight());
		setRoot(palette);
	}
	
	public List<?> getPalette() {
		return myPalette;
	}
	
	protected void makePalette(List<?> list) {
		
	}
}
