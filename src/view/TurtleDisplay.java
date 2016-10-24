package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import cursor.Coordinate;
import cursor.Drawable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 * @author John Martin
 *
 */
public class TurtleDisplay implements Display {
	
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
	private Image myTurtleImage = null;
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
        strokeCanvas();
        setBackgroundColor(AppResources.CANVAS_COLOUR.getColorResource());
        turtleX = 0;
        turtleY = 0;
        setTurtleImage("src/images/turtle.png");
        drawTurtle(turtleX, turtleY);
        
	}
	
	public void redrawAll(List<Drawable> drawables){
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
		}
		List<Coordinate> turtleCoordinates = drawables.get(drawables.size()-1).getCreateItems();
		turtleCoordinates.get(turtleCoordinates.size()-1);
		double turtleX = turtleCoordinates.get(turtleCoordinates.size()-1).getX();
		double turtleY = turtleCoordinates.get(turtleCoordinates.size()-1).getY();
		System.out.println("FrontEnd Test: " + "x = " + turtleX + " y = " + turtleY);
		drawTurtle(turtleX, turtleY);
	}
	
	private void drawLine(double x1, double y1, double x2, double y2){
		x1 = x1 + myCursorCanvas.getWidth()/2;
		y1 = -y1 + myCursorCanvas.getHeight()/2;
		x2 = x2 + myCursorCanvas.getWidth()/2;
		y2 = -y2 + myCursorCanvas.getHeight()/2;
		lineGC.setStroke(myLineStroke);
		lineGC.setLineWidth(myLineWidth);
		lineGC.strokeLine(x1, y1, x2, y2);
	}
	
	private void drawTurtle(double x, double y){
		turtleX = x + myCursorCanvas.getWidth()/2;
		turtleY = -y + myCursorCanvas.getHeight()/2;
		double turtleCornerX = turtleX - myTurtleWidth/2;
		double turtleCornerY = turtleY - myTurtleHeight/2;
		cursorGC.setFill(myTurtleFill);
        cursorGC.fillRect(turtleCornerX, turtleCornerY, myTurtleWidth, myTurtleHeight);
        cursorGC.drawImage(myTurtleImage, turtleCornerX, turtleCornerY, myTurtleWidth, myTurtleHeight);
	}
	
	private void clearCanvas(){
		cursorGC.clearRect(0, 0, myCursorCanvas.getWidth(), myCursorCanvas.getHeight());
		lineGC.clearRect(0, 0, myLineCanvas.getWidth(), myLineCanvas.getHeight());
		stampGC.clearRect(0, 0, myStampCanvas.getWidth(), myStampCanvas.getHeight());
	}
	
	private void strokeCanvas(){
		lineGC.setStroke(AppResources.LINE_STROKE.getColorResource());
		lineGC.setLineWidth(AppResources.LINE_WIDTH.getDoubleResource());
		double cWidth = lineGC.getCanvas().getWidth();
        double cHeight = lineGC.getCanvas().getHeight();
        lineGC.strokeLine(0, 0, 0, cHeight);
        lineGC.strokeLine(0, 0, cWidth, 0);
        lineGC.strokeLine(cWidth, 0, cWidth, cHeight);
        lineGC.strokeLine(0, cHeight, cWidth, cHeight);
	}
	
	public Node getStackPane(){
		return myStackPane;
	}
	
	public void setBackgroundColor(Color color){
		bgGC.setFill(color);
		bgGC.fillRect(0, 0, myBGCanvas.getWidth(), myBGCanvas.getHeight());
	}
	
	public void setPenColor(Color color){
		myLineStroke = color;
	}
	
	public void setTurtleImage(String path){
		try {
			Image img = new Image(new FileInputStream(path));
			myTurtleFill = Color.TRANSPARENT;
			myTurtleImage = img;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
