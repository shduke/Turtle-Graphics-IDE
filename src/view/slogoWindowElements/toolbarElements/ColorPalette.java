/**
 * 
 */
package view.slogoWindowElements.toolbarElements;

import java.util.List;

import javafx.geometry.Pos;
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

	public ColorPalette(HBox palette) {
		super(palette);
		setRoot(makeColorPalette());
	}
	
	private HBox makeColorPalette() {
		HBox hb = new HBox();
		VBox vb = new VBox();
		Rectangle square = new Rectangle(100, 100, Paint.valueOf("BLACK"));
		vb.getChildren().add(square);
		Label label = new Label("1");
		label.setPrefWidth(100);
		label.setAlignment(Pos.TOP_CENTER);
		vb.getChildren().add(label);
		hb.getChildren().add(vb);
		
		VBox vb1 = new VBox();
		square = new Rectangle(100, 100, Paint.valueOf("BLUE"));
		vb1.getChildren().add(square);
		Label label1 = new Label("2");
		label1.setPrefWidth(100);
		label1.setAlignment(Pos.TOP_CENTER);
		vb1.getChildren().add(label1);
		hb.getChildren().add(vb1);
		return hb;
	}
}
