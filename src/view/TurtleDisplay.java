package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;

/**
 * @author John Martin
 *
 */
public class TurtleDisplay {
	
	EventHandler<ActionEvent> myEvent;
	StackPane myStackPane = new StackPane();
	Canvas myCanvas = new Canvas(800, 400);
	
	public TurtleDisplay(EventHandler<ActionEvent> event) {
		myStackPane.setId("StackPane");
        myStackPane.getChildren().add(myCanvas);
	}
	
	public Node getStackPane(){
		return myStackPane;
	}

}
