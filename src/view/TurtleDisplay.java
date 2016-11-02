package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import cursor.Coordinate;
import cursor.ICoordinate;
import cursor.IDrawable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private Pane myBackgroundPane = new Pane();
	private Pane myLinePane = new Pane();
	private Pane myTurtlePane = new Pane();
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
	
	// Lists for Nodes
	private List<Rectangle> myTurtles = new ArrayList<Rectangle>();
	private List<Line> myLines = new ArrayList<Line>();
	
	// New Stuff for Nodes
	private Rectangle myTurtle;
	private ImageView myTurtleImageView;
	
	public TurtleDisplay(EventHandler<ActionEvent> event) {
		initPane(myBackgroundPane);
		initPane(myLinePane);
		initPane(myTurtlePane);
        turtleX = 0;
        turtleY = 0;
        setTurtleImage("src/images/turtle.png");
        myTurtle = drawTurtle(turtleX, turtleY);
        myTurtleImageView = drawCursorImage(myTurtleImage, turtleX, turtleY);
        myTurtle.setFill(Color.TRANSPARENT);
	}
	
	public void initPane(Pane p){
		p.setId("Pane");
		p.setMinWidth(myPaneWidth); p.setMinHeight(myPaneHeight);
		p.setPrefWidth(myPaneWidth); p.setPrefHeight(myPaneHeight);
		p.setMaxWidth(myPaneWidth); p.setMaxHeight(myPaneHeight);
		myGroup.getChildren().add(p);
	}
	

	public void redrawAll(List<IDrawable> drawables){
		for (IDrawable drawable : drawables){
			List<ICoordinate> coordinates = drawable.getDrawableCoordinates();
			double currentX = coordinates.get(0).getX();
			double currentY = coordinates.get(0).getY();
			for (ICoordinate coord : coordinates.subList(1, coordinates.size())){
				double nextX = coord.getX();
				double nextY = coord.getY();
				checkForLine(currentX, currentY, nextX, nextY);
				currentX = nextX; 
				currentY = nextY;
			}
		}
		IDrawable turtleDrawable = drawables.get(drawables.size()-1);
		List<ICoordinate> turtleCoordinates = turtleDrawable.getDrawableCoordinates();
		turtleCoordinates.get(turtleCoordinates.size()-1);
		double turtleX = turtleCoordinates.get(turtleCoordinates.size()-1).getX();
		double turtleY = turtleCoordinates.get(turtleCoordinates.size()-1).getY();
		myTurtleOrientation = turtleDrawable.getOrientation();
		System.out.println("FrontEnd Test: " + "x = " + turtleX + " y = " + turtleY + "Ori: " + myTurtleOrientation);
		setRectangle(myTurtle, turtleX, turtleY);
		setImageView(myTurtleImageView, turtleX, turtleY);
	}
	
	private void checkForLine(double x1, double y1, double x2, double y2){
		boolean match = false;
		for (Line testLine : myLines){
			if (testLine.getStartX() == x1 && testLine.getStartY() == y1 && testLine.getEndX() == x2 && testLine.getEndY() == y2){
				match = true;
			}
		}
		if (!match){
			drawLine(x1, y1, x2, y2);
		}
	}
	
	private void drawLine(double x1, double y1, double x2, double y2){
		x1 += myPaneWidth/2; y1 += myPaneHeight/2;
		x2 += myPaneWidth/2; y2 += myPaneHeight/2;
		Line newLine = new Line(x1, y1, x2, y2);
		newLine.setStrokeWidth(myLineWidth);
		newLine.setStroke(myLineStroke);
		myLinePane.getChildren().add(newLine);
	}
	
	private void setRectangle(Rectangle t, double x, double y){
		x += myPaneWidth/2;
		y += myPaneHeight/2;
		double leftX = x - myTurtleWidth/2;
		double topY = y - myTurtleHeight/2;
		t.setX(leftX);
		t.setY(topY);
	}
	
	private void setImageView(ImageView iv, double x, double y){
		x += myPaneWidth/2;
		y += myPaneHeight/2;
		double leftX = x - myTurtleWidth/2;
		double topY = y - myTurtleHeight/2;
		iv.setX(leftX);
		iv.setY(topY);
	}
	
	private Rectangle drawTurtle(double x, double y){
		Rectangle r = new Rectangle(x, y, myTurtleWidth, myTurtleHeight);
		r.setFill(Color.RED);
		myTurtlePane.getChildren().add(r);
		setRectangle(r, x, y);
		return r;
	}
	
	private ImageView drawCursorImage(Image img, double x, double y){
		ImageView imgView = new ImageView(img);
		imgView.setFitWidth(myTurtleWidth);
		imgView.setFitHeight(myTurtleHeight);
		imgView.setRotate(myTurtleOrientation);
		myTurtlePane.getChildren().add(imgView);
		setImageView(imgView, x, y);
		return imgView;
	}
		
	private void strokePane(){
		double pWidth = myLinePane.getWidth();
        double pHeight = myLinePane.getHeight();
		drawLine(0, 0, 0, pHeight);
		drawLine(0, 0, pWidth, 0);
		drawLine(pWidth, 0, pWidth, pHeight);
		drawLine(0, pHeight, pWidth, pHeight);
	}
	
	private void clearAllPanes(){
		myLinePane.getChildren().clear();
		myTurtlePane.getChildren().clear();
	}
	
	public Group getGroup(){
		return myGroup;
	}
	
	public void setBackgroundColor(Color color){
		String hex = String.format( "#%02X%02X%02X",
		            (int)( color.getRed() * 255 ),
		            (int)( color.getGreen() * 255 ),
		            (int)( color.getBlue() * 255 ) );
		myBackgroundPane.setStyle("-fx-background-color: " + hex);
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
