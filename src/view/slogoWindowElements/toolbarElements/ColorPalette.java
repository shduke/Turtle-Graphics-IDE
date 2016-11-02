/**
 * 
 */
package view.slogoWindowElements.toolbarElements;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;

/**
 * @author Noel Moon (nm142)
 *
 */
public class ColorPalette extends Palette {
	
	private List<String> myColorPaletteList;

	public ColorPalette(List<String> colorList) {
		super();
		setRoot(makePalette(makeColorList(colorList)));
	}
	
	private List<Node> makeColorList(List<String> colorList) {
		List<Node> list = new ArrayList<Node>();
		for (int i=0; i<5; i++) {
			Rectangle square = new Rectangle(100, 100, Paint.valueOf(colorList.get(i)));
			list.add(square);
		}
		return list;
	}
}
