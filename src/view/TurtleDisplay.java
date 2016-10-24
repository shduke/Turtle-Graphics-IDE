package view;

import java.util.List;

import cursor.Coordinate;
import cursor.Drawable;
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
	
	// Canvas Layers
	private Canvas myBGCanvas = new Canvas(AppResources.CANVAS_WIDTH.getDoubleResource(), AppResources.CANVAS_HEIGHT.getDoubleResource());
	private GraphicsContext bgGC = myBGCanvas.getGraphicsContext2D();
	private Canvas myCursorCanvas = new Canvas(AppResources.CANVAS_WIDTH.getDoubleResource(), AppResources.CANVAS_HEIGHT.getDoubleResource());
	private GraphicsContext cursorGC = myCursorCanvas.getGraphicsContext2D();
	private Canvas myLineCanvas = new Canvas(AppResources.CANVAS_WIDTH.getDoubleResource(), AppResources.CANVAS_HEIGHT.getDoubleResource());
	private GraphicsContext lineGC = myLineCanvas.getGraphicsContext2D();
	private Canvas myStampCanvas = new Canvas(AppResources.CANVAS_WIDTH.getDoubleResource(), AppResources.CANVAS_HEIGHT.getDoubleResource());
	private GraphicsContext stampGC = myStampCanvas.getGraphicsContext2D();
	
	// Turtle Characteristics
	private double myTurtleWidth = AppResources.TURTLE_WIDTH.getDoubleResource();
	private double myTurtleHeight = AppResources.TURTLE_HEIGHT.getDoubleResource();
	private Color myTurtleFill = AppResources.TURTLE_FILL.getColorResource();
	private double turtleX, turtleY;
	
	// Line Characteristics
	private double myLineWidth = AppResources.LINE_WIDTH.getDoubleResource();
	private Color myLineStroke = AppResources.LINE_STROKE.getColorResource();
	
	public TurtleDisplay(EventHandler<ActionEvent> event) {
		myStackPane.setId("StackPane");
		myStackPane.getChildren().add(myBGCanvas);
        myStackPane.getChildren().add(myCursorCanvas);
        myStackPane.getChildren().add(myLineCanvas);
        myStackPane.getChildren().add(myStampCanvas);
        myCursorCanvas.toFront();
        myLineCanvas.toBack();
        myBGCanvas.toBack();
        turtleX = myCursorCanvas.getWidth()/2 - myTurtleWidth/2;
        turtleY = myCursorCanvas.getHeight()/2 - myTurtleHeight/2;
        drawTurtle(turtleX, turtleY);
        
	}
	
	//TODO: Refactor "drawDrawables" method name below, cause, I mean, reall...
	private void redrawAll(List<Drawable> drawables){
		clearCanvas();
		strokeCanvas();
		for (Drawable drawable : drawables){
			List<Coordinate> coordinates = drawable.getCreateItems();
			double currentX = coordinates.get(0).getX();
			double currentY = coordinates.get(0).getY();
			for (Coordinate coord : coordinates.subList(1, coordinates.size())){
				double nextX = coord.getX();
				double nextY = coord.getY();
				drawLine(currentX, currentY, nextX, nextY);
				currentX = nextX; 
				currentY = nextY;
			}
			double turtleX = coordinates.get(coordinates.size()).getX();
			double turtleY = coordinates.get(coordinates.size()).getY();
			drawTurtle(turtleX, turtleY);
		}
	}
	
	private void drawLine(double x1, double y1, double x2, double y2){
		lineGC.setStroke(AppResources.LINE_STROKE.getColorResource());
		lineGC.setLineWidth(AppResources.LINE_WIDTH.getDoubleResource());
		lineGC.strokeLine(x1, y1, x2, y2);
	}
	
	private void drawTurtle(double x, double y){
		turtleX = x;
		turtleY = y;
		cursorGC.setFill(myTurtleFill);
        cursorGC.fillRect(x, y, myTurtleWidth, myTurtleHeight);
	}
	
	private void clearCanvas(){
		cursorGC.clearRect(0, 0, myCursorCanvas.getWidth(), myCursorCanvas.getHeight());
		lineGC.clearRect(0, 0, myLineCanvas.getWidth(), myLineCanvas.getHeight());
		stampGC.clearRect(0, 0, myStampCanvas.getWidth(), myStampCanvas.getHeight());
	}
	
	public void strokeCanvas(){
		lineGC.setStroke(AppResources.LINE_STROKE.getColorResource());
		lineGC.setLineWidth(AppResources.LINE_WIDTH.getDoubleResource());
		double cWidth = lineGC.getCanvas().getWidth();
        double cHeight = lineGC.getCanvas().getHeight();
        lineGC.strokeLine(0, 0, 0, cHeight);
        lineGC.strokeLine(0, 0, cWidth, 0);
        lineGC.strokeLine(cWidth, 0, cWidth, cHeight);
        lineGC.strokeLine(0, cHeight, cWidth, cHeight);
	}
	
	public void advanceTurtleTest(double x, double y){
		clearCanvas();
		strokeCanvas();
		double newTurtleX = turtleX + x;
        double newTurtleY = turtleY + y;
        drawLine(turtleX, turtleY, newTurtleX, newTurtleY);
        drawTurtle(newTurtleX, newTurtleY);
	}
	
	public Node getStackPane(){
		return myStackPane;
	}
	
	public void setBackgroundColour(Color color){
		bgGC.setFill(color);
		bgGC.fillRect(0, 0, myBGCanvas.getWidth(), myBGCanvas.getHeight());
	}
	
	public void setTurtleImage(){
		//TODO SET TURTLE IMAGE
	}
	
}
