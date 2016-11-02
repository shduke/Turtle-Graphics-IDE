package view;

import java.util.List;


import cursor.IDrawable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;

/**
 * @author John Martin (jfm41)
 *
 */
public interface Display {
		
	public void addDrawables(List<IDrawable> drawables);
	
	public void setBackgroundColor(Color color);
	
	public void setPenColor(Color color);
		
	public Group getGroup();
	
	public void setTurtleImage(String path);
	
}
