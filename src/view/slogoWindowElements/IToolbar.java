package view.slogoWindowElements;

import java.util.List;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * @author Noel Moon (nm142)
 *
 */
public interface IToolbar {

	public HBox getToolbar();
	
	public Color getColor(double i);
	
	public void setColor(double index, Color color);
}
