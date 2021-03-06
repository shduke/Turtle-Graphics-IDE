package view;

import java.util.List;


import cursor.IDrawable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;

/**
 * @author John Martin (jfm41)
 *
 */
public interface Display {
		
	public void addDrawables(List<IDrawable> drawables);
	
	public void setBackgroundColor(Color color);
	
	public void setPenColor(Color color);
	
	public void setPenWidth(double width);
		
	public Group getGroup();
	
	public ScrollPane getScrollPane();
	
	public void setTurtleImage(String path);
	
	public void resetDisplay();

	public void setLineType(double doubleResource);
	
}
