/**
 * 
 */
package view.slogoWindowElements.toolbarElements;

import java.awt.Dimension;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * @author Noel Moon (nm142)
 *
 */
public abstract class Palette extends Property {
	
	public static final Dimension DEFAULT_SIZE = new Dimension(500, 120);
	
	public Palette() {
		super(DEFAULT_SIZE.getWidth(), DEFAULT_SIZE.getHeight());
	}
	
	protected HBox makePalette(List<Node> list) {
		HBox hb = new HBox();
		for (int i=0; i<5; i++) {
			VBox vb = new VBox();
			vb.getChildren().add(list.get(i));
			Label label = new Label(Integer.toString(i));
			label.setPrefWidth(100);
			label.setAlignment(Pos.TOP_CENTER);
			vb.getChildren().add(label);
			hb.getChildren().add(vb);
		}
		return hb;
	}
}
