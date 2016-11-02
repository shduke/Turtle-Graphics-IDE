package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import cursor.ICoordinate;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import cursor.Coordinate;
import cursor.IDrawable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * @author John Martin
 *
 */
public class TurtleDisplay implements Display {
	
	// Pane Characteristics
	private EventHandler<ActionEvent> myEvent;
	private Group myGroup = new Group();
	private Pane myBackgroundPane = new Pane();
	private Pane myLinePane = new Pane();
	private Pane myTurtlePane = new Pane();
	private double myPaneWidth = AppResources.CANVAS_WIDTH.getDoubleResource();
	private double myPaneHeight = AppResources.CANVAS_HEIGHT.getDoubleResource();
	
	private double lineLayerNum = AppResources.LINE_LAYER_NUM.getDoubleResource();
	private double turtleLayerNum = AppResources.TURTLE_LAYER_NUM.getDoubleResource();
	
	// Turtle Characteristics
	private double myTurtleWidth = AppResources.TURTLE_WIDTH.getDoubleResource();
	private double myTurtleHeight = AppResources.TURTLE_HEIGHT.getDoubleResource();
	private double myTurtleOrientationDefault = 90;
	private double myInitTurtleID = AppResources.INIT_TURTLE_ID.getDoubleResource();
	private Color myTurtleFill = AppResources.TURTLE_FILL.getColorResource();
	private Image myTurtleImage = null;
	private double turtleX, turtleY;
	
	// Line Characteristics
	private double myLineWidth = AppResources.NORMAL_LINE_WIDTH.getDoubleResource();
	private Color myLineStroke = AppResources.LINE_STROKE.getColorResource();
	
	// Lists for Nodes
	private List<Rectangle> myTurtles = new ArrayList<Rectangle>();
	private List<ImageView> myTurtleImageViews = new ArrayList<ImageView>();
	private List<Line> myLines = new ArrayList<Line>();
	
	// Drawable List
	private ArrayList<List<IDrawable>> myAnimationQueue = new ArrayList<List<IDrawable>>();
	private Timeline myAnimationTimeline;
	private boolean animating = false;
	private double msPerPixel = 1;
	
	public TurtleDisplay(EventHandler<ActionEvent> event) {
		initPane(myBackgroundPane);
		initPane(myLinePane);
		initPane(myTurtlePane);
		myTurtlePane.setOnMouseClicked(e -> handleMouseInput(e.getX(), e.getY()));
        turtleX = 0;
        turtleY = 0;
        setTurtleImage("src/images/turtle.png");
        drawTurtle(turtleX, turtleY, myInitTurtleID, myTurtleOrientationDefault);
        myTurtles.get(0).setFill(Color.TRANSPARENT);
        KeyFrame frame = new KeyFrame(Duration.millis(AppResources.ANIMATION_SPEED.getDoubleResource()),
                e -> step());
	    myAnimationTimeline = new Timeline();
	    myAnimationTimeline.setCycleCount(Timeline.INDEFINITE);
	    myAnimationTimeline.getKeyFrames().add(frame);
	}
	
	public void initPane(Pane p){
		p.setId("Pane");
		p.setMinWidth(myPaneWidth); p.setMinHeight(myPaneHeight);
		p.setPrefWidth(myPaneWidth); p.setPrefHeight(myPaneHeight);
		p.setMaxWidth(myPaneWidth); p.setMaxHeight(myPaneHeight);
		myGroup.getChildren().add(p);
	}

	public void addDrawables(List<IDrawable> drawables){
		if (animating){
			myAnimationQueue.add(drawables);
		} else {
			redrawAll(drawables);
		}
	}
	
	private void step(){
		if (myAnimationTimeline.getKeyFrames().size() == 1){
			redrawAll(myAnimationQueue.get(0));
			myAnimationQueue.remove(0);
		}
	}
	
	private void toggleRunning() {
        if (myAnimationTimeline.getStatus().equals(Animation.Status.RUNNING)) {
        	myAnimationTimeline.pause();
        	toggleAnimationButton.setText(AppResources.RUN_TITLE.getResource());
        } else {
        	myAnimationTimeline.play();
            toggleAnimationButton.setText(AppResources.PAUSE_TITLE.getResource());
        }
    }
	
	private void animateTurtle(Rectangle t, double destinationX, double destinationY, double orientation){
		t.setRotate(orientation);
		ImageView turtleImage = myTurtleImageViews.get(myTurtles.indexOf(t));
		double leftX = destinationX + myPaneWidth/2 - myTurtleWidth/2;
		double topY = destinationY + myPaneHeight/2 - myTurtleHeight/2;
		KeyValue kvTurtleX = new KeyValue(t.xProperty(), leftX);
		KeyValue kvTurtleY = new KeyValue(t.yProperty(), topY);
		KeyValue kvIVX = new KeyValue(turtleImage.xProperty(), leftX);
		KeyValue kvIVY = new KeyValue(turtleImage.yProperty(), topY);
		double xTime = msPerPixel*Math.abs(t.getX()-leftX);
		double yTime = msPerPixel*Math.abs(t.getY()-topY);
		KeyFrame kfTurtleX = new KeyFrame(Duration.millis(xTime), kvTurtleX);
		KeyFrame kfTurtleY = new KeyFrame(Duration.millis(yTime), kvTurtleY);
		KeyFrame kfIVX = new KeyFrame(Duration.millis(xTime), kvIVX);
		KeyFrame kfIVY = new KeyFrame(Duration.millis(yTime), kvIVY);
		myAnimationTimeline.getKeyFrames().addAll(kfTurtleX, kfTurtleY, kfIVX, kfIVY);
	}
	
	public void redrawAll(List<IDrawable> drawables){
		System.out.println("Redraw All");
		System.out.println(drawables.size());
		for (IDrawable drawable : drawables){
			if (drawable.getLayer() == lineLayerNum){
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
				System.out.println("Found a line");
			} else if (drawable.getLayer() == turtleLayerNum){
				checkForTurtle(drawable);
				System.out.println("Found a turtle");
			}
			System.out.println(drawable.getLayer());
			System.out.println(drawable.getId());
		}
	}
	
	private void checkForLine(double x1, double y1, double x2, double y2){
		boolean match = false;
		for (Line testLine : myLines){
			if (testLine.getStartX() == x1 && testLine.getStartY() == y1 && testLine.getEndX() == x2 && testLine.getEndY() == y2){
				match = true;
				break;
			}
		}
		if (!match){
			drawLine(x1, y1, x2, y2);
		}
	}
	
	private void checkForTurtle(IDrawable turtle){
		List<ICoordinate> turtleCoordinates = turtle.getDrawableCoordinates();
		turtleCoordinates.get(turtleCoordinates.size()-1);
		double turtleX = turtleCoordinates.get(turtleCoordinates.size()-1).getX();
		double turtleY = turtleCoordinates.get(turtleCoordinates.size()-1).getY();
		double turtleOrientation = turtle.getOrientation();
		boolean match = false;
		double turtleID = turtle.getId();
		String turtleIDString = Double.toString(turtleID);
		for (Rectangle testTurtle : myTurtles){
			if (testTurtle.getId() == turtleIDString && animating){
				animateTurtle(testTurtle, turtleX, turtleY, turtleOrientation);
			} else if (testTurtle.getId() == turtleIDString && !animating){
				setTurtle(testTurtle, turtleX, turtleY, turtleOrientation);
				System.out.println("Match");
			}
		}
		if (!match){
			System.out.println("No Match");
			drawTurtle(turtleX, turtleY, turtleID, turtleOrientation);
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
	
	
	private void setTurtle(Rectangle t, double x, double y, double orientation){
		double leftX =  x + myPaneWidth/2 - myTurtleWidth/2;
		double topY = y + myPaneHeight/2 - myTurtleHeight/2;
		t.setX(leftX);
		t.setY(topY);
		t.setRotate(orientation);
		setImageView(myTurtleImageViews.get(myTurtles.indexOf(t)), leftX, topY, orientation);
	}
	
	
	private void setImageView(ImageView iv, double leftX, double topY, double orientation){
		iv.setX(leftX);
		iv.setY(topY);
		iv.setRotate(orientation);
	}
	
	private Rectangle drawTurtle(double x, double y, double id, double orientation){
		Rectangle r = new Rectangle(x, y, myTurtleWidth, myTurtleHeight);
		r.setFill(Color.RED);
		r.setId(Double.toString(id));
		myTurtles.add(r);
		myTurtlePane.getChildren().add(r);
		drawCursorImage(myTurtleImage);
		setTurtle(r, x, y, orientation);
		return r;
	}
	
	private ImageView drawCursorImage(Image img){
		ImageView imgView = new ImageView(img);
		imgView.setFitWidth(myTurtleWidth);
		imgView.setFitHeight(myTurtleHeight);
		myTurtlePane.getChildren().add(imgView);
		myTurtleImageViews.add(imgView);
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
	
	private void handleMouseInput(double x, double y) {
    	Rectangle mousePos = new Rectangle(x, y, 1, 1);
		for (Rectangle turtle : myTurtles){
			if (mousePos.getBoundsInParent().intersects(turtle.getBoundsInParent())){
				turtle.setFill(Color.AQUA);
			}
		}
	}	
	
}
