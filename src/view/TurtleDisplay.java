package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import cursor.Coordinate;
import cursor.Drawable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 * @author John Martin
 *
 */
public class TurtleDisplay implements Display {
	
	private EventHandler<ActionEvent> myEvent;
	private Group myGroup = new Group();
	private Pane myPane = new Pane();
	private double myPaneWidth = AppResources.CANVAS_WIDTH.getDoubleResource();
	private double myPaneHeight = AppResources.CANVAS_HEIGHT.getDoubleResource();
	
	// Turtle Characteristics
	private double myTurtleWidth = AppResources.TURTLE_WIDTH.getDoubleResource();
	private double myTurtleHeight = AppResources.TURTLE_HEIGHT.getDoubleResource();
	private Color myTurtleFill = AppResources.TURTLE_FILL.getColorResource();
	private Image myTurtleImage = null;
	private double turtleX, turtleY;
	private double myTurtleOrientation = 90;
	
	// Line Characteristics
	private double myLineWidth = AppResources.LINE_WIDTH.getDoubleResource();
	private Color myLineStroke = AppResources.LINE_STROKE.getColorResource();
	
	// New Stuff for Nodes
	private Rectangle myTurtle;
	
	public TurtleDisplay(EventHandler<ActionEvent> event) {
		myPane.setId("Pane");
		myPane.setMinWidth(myPaneWidth); myPane.setMinHeight(myPaneHeight);
		myPane.setPrefWidth(myPaneWidth); myPane.setPrefHeight(myPaneHeight);
		myPane.setMaxWidth(myPaneWidth); myPane.setMaxHeight(myPaneHeight);
		myGroup.getChildren().add(myPane);
        turtleX = 0;
        turtleY = 0;
        drawTurtle(turtleX, turtleY);
//        drawTurtle(turtleX, turtleY);   
	}
	
	public void redrawAll(List<Drawable> drawables){
		clearPane();
		strokePane();
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
		Drawable turtleDrawable = drawables.get(drawables.size()-1);
		List<Coordinate> turtleCoordinates = turtleDrawable.getCreateItems();
		turtleCoordinates.get(turtleCoordinates.size()-1);
		double turtleX = turtleCoordinates.get(turtleCoordinates.size()-1).getX();
		double turtleY = turtleCoordinates.get(turtleCoordinates.size()-1).getY();
		myTurtleOrientation = turtleDrawable.getOrientation();
		System.out.println("FrontEnd Test: " + "x = " + turtleX + " y = " + turtleY + "Ori: " + myTurtleOrientation);
		drawTurtle(turtleX, turtleY);
	}
	
	private void drawLine(double x1, double y1, double x2, double y2){
		double lineHeight = Math.abs(y2 - y1);
		Line newLine = new Line(x1, y1, x2, y2);
		newLine.setStrokeWidth(myLineWidth);
		myPane.getChildren().add(newLine);
	}
	
	private void drawTurtle(double x, double y){
		x += myPaneWidth/2;
		y += myPaneHeight/2;
		double leftX = x - myTurtleWidth/2;
		double topY = y - myTurtleHeight/2;
		Rectangle turtleRect = new Rectangle(leftX, topY, myTurtleWidth, myTurtleHeight);
		turtleRect.setFill(Color.RED);
		myPane.getChildren().add(turtleRect);
	}
	
	private void drawCursorImage(double cornerX, double cornerY){
		// Rotate Cursor Image
	}
	
	private void strokePane(){
		double pWidth = myPane.getWidth();
        double pHeight = myPane.getHeight();
		drawLine(0, 0, 0, pHeight);
		drawLine(0, 0, pWidth, 0);
		drawLine(pWidth, 0, pWidth, pHeight);
		drawLine(0, pHeight, pWidth, pHeight);
	}
	
	private void clearPane(){
		myPane.getChildren().clear();
	}
	
	public Group getGroup(){
		return myGroup;
	}
	
	public void setBackgroundColor(Color color){
		String hex = String.format( "#%02X%02X%02X",
		            (int)( color.getRed() * 255 ),
		            (int)( color.getGreen() * 255 ),
		            (int)( color.getBlue() * 255 ) );
		myPane.setStyle("-fx-background-color: " + hex);
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
