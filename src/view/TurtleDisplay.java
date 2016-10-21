package view;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 * @author John Martin
 *
 */
public class TurtleDisplay {
	
	private EventHandler<ActionEvent> myEvent;
	private StackPane myStackPane = new StackPane();
	private Canvas myCanvas = new Canvas(AppResources.CANVAS_WIDTH.getDoubleResource(), AppResources.CANVAS_HEIGHT.getDoubleResource());
	private GraphicsContext myGC = myCanvas.getGraphicsContext2D();
	private Rectangle myRectangle1, myRectangle2;
	private double turtleWidth = AppResources.TURTLE_WIDTH.getDoubleResource();
	private double turtleHeight = AppResources.TURTLE_HEIGHT.getDoubleResource();
	private double turtleX, turtleY;
	
	private List<Rectangle> myTurtles;
	private List<Line> myLines;
	
	public TurtleDisplay(EventHandler<ActionEvent> event) {
		myStackPane.setId("StackPane");
        myStackPane.getChildren().add(myCanvas);
        turtleX = myCanvas.getWidth()/2 - turtleWidth/2;
        turtleY = myCanvas.getHeight()/2 - turtleHeight/2;
        drawTurtle(turtleX, turtleY);
        
	}
	
	private void redrawAll(List<Rectangle> turtles, List<Line> lines){
		clearCanvas();
		if (turtles == null){
			turtles = myTurtles;
		}
		if (lines == null){
			lines = myLines;
		}
		drawManyLines(lines);
		drawManyTurtles(turtles);
		myTurtles = turtles;
		myLines = lines;
	}
	
	private void clearCanvas(){
		myGC.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
	}
	
	// TODO: refactor to structure of what backend passes up
	private void drawManyLines(List<Line> lines){
		for (Line line : lines){
			double x1 = line.getStartX();
			double y1 = line.getStartY();
			double y2 = line.getEndY();
			double x2 = line.getEndX();
			drawLine(x1, y1, x2, y2);
		}
	}
	// TODO: refactor to structure of what backend passes up
	private void drawManyTurtles(List<Rectangle> turtles){
		for (Rectangle turtle : turtles){
			double x = turtle.getX();
			double y = turtle.getY();
			drawTurtle(x, y);
		}
	}
	
	private void drawLine(double x1, double y1, double x2, double y2){
		myGC.setStroke(AppResources.LINE_STROKE.getColorResource());
        myGC.setLineWidth(AppResources.LINE_WIDTH.getDoubleResource());
        myGC.strokeLine(x1, y1, x2, y2);
	}
	
	private void drawTurtle(double x, double y){
		turtleX = x;
		turtleY = y;
		myGC.setFill(AppResources.TURTLE_FILL.getColorResource());
        myGC.setStroke(AppResources.LINE_STROKE.getColorResource());
        myGC.setLineWidth(AppResources.LINE_WIDTH.getDoubleResource());
        myGC.fillRect(x, y, turtleWidth, turtleHeight);
        double cWidth = myGC.getCanvas().getWidth();
        double cHeight = myGC.getCanvas().getHeight();
        myGC.strokeLine(0, 0, 0, cHeight);
        myGC.strokeLine(0, 0, cWidth, 0);
        myGC.strokeLine(cWidth, 0, cWidth, myGC.getCanvas().getHeight());
        myGC.strokeLine(0, cHeight, cWidth, cHeight);
	}
	
	public void advanceTurtleTest(double x, double y){
		clearCanvas();
		double newTurtleX = turtleX + x;
        double newTurtleY = turtleY + y;
        drawLine(turtleX, turtleY, newTurtleX, newTurtleY);
        drawTurtle(newTurtleX, newTurtleY);
	}
	
	public Node getStackPane(){
		return myStackPane;
	}

}
