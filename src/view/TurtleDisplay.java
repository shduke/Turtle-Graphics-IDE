package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author John Martin
 *
 */
public class TurtleDisplay {
	
	private EventHandler<ActionEvent> myEvent;
	private StackPane myStackPane = new StackPane();
	private Canvas myCanvas = new Canvas(AppResources.CANVAS_WIDTH.getDoubleResource(), AppResources.CANVAS_HEIGHT.getDoubleResource());
	private GraphicsContext gc = myCanvas.getGraphicsContext2D();
	private Rectangle myRectangle1, myRectangle2;
	private double turtleWidth = AppResources.TURTLE_WIDTH.getDoubleResource();
	private double turtleHeight = AppResources.TURTLE_HEIGHT.getDoubleResource();
	private double turtleX, turtleY;
	
	public TurtleDisplay(EventHandler<ActionEvent> event) {
		myStackPane.setId("StackPane");
        myStackPane.getChildren().add(myCanvas);
        turtleX = myCanvas.getWidth()/2 - turtleWidth/2;
        turtleY = myCanvas.getHeight()/2 - turtleHeight/2;
        redrawTurtle(turtleX, turtleY);
        
	}
	
	private void redrawTurtle(double x, double y){
		gc.clearRect(turtleX, turtleY, turtleWidth, turtleHeight);
		turtleX = x;
		turtleY = y;
		gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.fillRect(x, y, turtleWidth, turtleHeight);
        double cWidth = gc.getCanvas().getWidth();
        double cHeight = gc.getCanvas().getHeight();
        gc.strokeLine(0, 0, 0, cHeight);
        gc.strokeLine(0, 0, cWidth, 0);
        gc.strokeLine(cWidth, 0, cWidth, gc.getCanvas().getHeight());
        gc.strokeLine(0, cHeight, cWidth, cHeight);
	}
	
	public void advanceTurtle(double x, double y){
		double newTurtleX = turtleX + x;
        double newTurtleY = turtleY + y;
        redrawTurtle(newTurtleX, newTurtleY);
	}
	
	public Node getStackPane(){
		return myStackPane;
	}

}
