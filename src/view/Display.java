package view;

import java.util.List;

import cursor.Drawable;
import javafx.scene.Node;
import javafx.scene.paint.Color;

/**
 * @author John Martin (jfm41)
 *
 */
public interface Display {
	
	public void redrawAll(List<Drawable> drawables);
	
	public void setBackgroundColor(Color color);
	
	public void setPenColor(Color color);
	
	public Node getStackPane();
	
	public void setTurtleImage(String path);
	
}
