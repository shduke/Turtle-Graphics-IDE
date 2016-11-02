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
import cursor.IDrawable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
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
	private Pane myForegroundPane = new Pane();
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
	private double initTurtleX, initTurtleY;
	
	// Line Characteristics
	private double myLineWidth = AppResources.NORMAL_LINE_WIDTH.getDoubleResource();
	private Color myLineStroke = AppResources.LINE_STROKE.getColorResource();
	private List<Double> myDashArray = new ArrayList<Double>();
	
	// Lists for Nodes
	private List<Rectangle> myTurtles = new ArrayList<Rectangle>();
	private List<ImageView> myTurtleImageViews = new ArrayList<ImageView>();
	private List<Line> myLines = new ArrayList<Line>();
	
	// Drawable List
	private ArrayList<List<IDrawable>> myAnimationQueue = new ArrayList<List<IDrawable>>();
	private Timeline myAnimationTimeline;
	private boolean animatingToggle = false;
	private boolean setToRun = false;
	private double msPerPixel = AppResources.MILLI_PER_PX.getDoubleResource();
	private Button toggleAnimationButton = new Button();
	private Button runAnimationButton = new Button();
	private List<Timeline> myTimelines = new ArrayList<Timeline>();
	
	public TurtleDisplay(EventHandler<ActionEvent> event) {
		initPane(myBackgroundPane);
		initPane(myLinePane);
		initPane(myTurtlePane);
		initPane(myForegroundPane);
		initButton(runAnimationButton, AppResources.RUN_TITLE.getResource(), new RunToggleEvent(), 1, 5);
		initButton(toggleAnimationButton, AppResources.TOGGLE_ON_TITLE.getResource(), new AnimationToggleEvent(), 2, 15);
		myForegroundPane.getChildren().addAll(runAnimationButton, toggleAnimationButton);
		myForegroundPane.setOnMouseClicked(e -> handleMouseInput(e.getX(), e.getY()));
		initTurtleX = 0;
		initTurtleY = 0;
        setTurtleImage("src/images/turtle.png");
        drawTurtle(initTurtleX, initTurtleY, myInitTurtleID, myTurtleOrientationDefault);
        KeyFrame frame = new KeyFrame(Duration.millis(AppResources.ANIMATION_SPEED.getDoubleResource()),
                e -> step());
	    myAnimationTimeline = new Timeline();
	    myAnimationTimeline.setCycleCount(Timeline.INDEFINITE);
	    myAnimationTimeline.getKeyFrames().add(frame);
		setLineType(AppResources.SOLID_LINE_TYPE.getDoubleResource());
	}
	
	public void initButton(Button b, String label, EventHandler<ActionEvent> eh, int pos, int gap){
		double width = AppResources.ANIMATION_BUTTON_WIDTH.getDoubleResource();
		double height = AppResources.ANIMATION_BUTTON_HEIGHT.getDoubleResource();
		b.setMinWidth(width); b.setMaxWidth(width);
		b.setMinHeight(height);	b.setMaxHeight(height);
		b.setLayoutX(myPaneWidth - width);
		b.setLayoutY(myPaneHeight - pos*height - gap);
		b.setText(label);
		b.setOnAction(eh);
	}
	
	public void initPane(Pane p){
		p.setId("Pane");
		p.setMinWidth(myPaneWidth); p.setMinHeight(myPaneHeight);
		p.setPrefWidth(myPaneWidth); p.setPrefHeight(myPaneHeight);
		p.setMaxWidth(myPaneWidth); p.setMaxHeight(myPaneHeight);
		myGroup.getChildren().add(p);
	}

	public void addDrawables(List<IDrawable> drawables){
		if (animatingToggle){
			myAnimationQueue.add(drawables);
		} else {
			redrawAll(drawables);
		}
	}
	
	private void step(){
		if (myTimelines.size() == 0 && animatingToggle && myAnimationQueue.size() > 0){
			redrawAll(myAnimationQueue.get(0));
			myAnimationQueue.remove(0);
		}
		List<Timeline> removeTimelines = new ArrayList<Timeline>();
		for (Timeline tl : myTimelines){
			if (tl.getStatus().equals(Animation.Status.STOPPED)){
				removeTimelines.add(tl);
			}
		}
		myTimelines.removeAll(removeTimelines);
		
	}
	
	private void animateTurtle(Rectangle t, double destinationX, double destinationY, double orientation){
		double leftX = destinationX + myPaneWidth/2 - myTurtleWidth/2;
		double topY = -destinationY + myPaneHeight/2 - myTurtleHeight/2;
		double time = msPerPixel*Math.sqrt(Math.pow((t.getX()-leftX), 2)+Math.pow((t.getY()-topY), 2));
		Timeline timeline = new Timeline();
	    myTimelines.add(timeline);
		t.setRotate(90-orientation);
		ImageView turtleImage = myTurtleImageViews.get(myTurtles.indexOf(t));
		turtleImage.setRotate(90-orientation);
		KeyValue kvTurtleX = new KeyValue(t.xProperty(), leftX);
		KeyValue kvTurtleY = new KeyValue(t.yProperty(), topY);
		KeyValue kvIVX = new KeyValue(turtleImage.xProperty(), leftX);
		KeyValue kvIVY = new KeyValue(turtleImage.yProperty(), topY);
		KeyFrame kfTurtleX = new KeyFrame(Duration.millis(time), kvTurtleX);
		KeyFrame kfTurtleY = new KeyFrame(Duration.millis(time), kvTurtleY);
		KeyFrame kfIVX = new KeyFrame(Duration.millis(time), kvIVX);
		KeyFrame kfIVY = new KeyFrame(Duration.millis(time), kvIVY);
		timeline.getKeyFrames().addAll(kfTurtleX, kfTurtleY, kfIVX, kfIVY);
	    timeline.play();
	}
	
	private void animateLine(double x1, double y1, double x2, double y2){
		double time = msPerPixel*Math.sqrt(Math.pow((x1-x2), 2)+Math.pow((y1-y2), 2));
		Timeline timeline = new Timeline();
	    myTimelines.add(timeline);
	    drawLine(x1, y1, x1, y1);
		x2 += myPaneWidth/2; y2 = -y2 + myPaneHeight/2;
		Line newLine = myLines.get(myLines.size()-1);
		KeyValue kvLineX = new KeyValue(newLine.endXProperty(), x2);
		KeyValue kvLineY = new KeyValue(newLine.endYProperty(), y2);
		KeyFrame kfLineX = new KeyFrame(Duration.millis(time), kvLineX);
		KeyFrame kfLineY = new KeyFrame(Duration.millis(time), kvLineY);
		timeline.getKeyFrames().addAll(kfLineX, kfLineY);
	    timeline.play();
	}
	
	public void redrawAll(List<IDrawable> drawables){
		System.out.println("------- Redraw All Called -------");
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
			} else if (drawable.getLayer() == turtleLayerNum){
				checkForTurtle(drawable);
			}
		}
	}
	
	private void checkForLine(double x1, double y1, double x2, double y2){
		boolean match = false;
		double newX1 = x1 + myPaneWidth/2; double newY1 = -y1 + myPaneHeight/2;
		double newX2 = x2 + myPaneWidth/2; double newY2 = -y2 + myPaneHeight/2;
		for (Line testLine : myLines){
			double tX1 = testLine.getStartX(); double tY1 = testLine.getStartY();
			double tX2 = testLine.getStartX(); double tY2 = testLine.getEndY();
			double absx1x1 = Math.abs(tX1-newX1); double absx2x2 = Math.abs(tX2-newX2);
			double absy1y1 = Math.abs(tY1-newY1); double absy2y2 = Math.abs(tY2-newY2);
			if ((absx1x1 < 1 && absx2x2 < 1 && absy1y1 < 1 && absy2y2 < 1)){
				match = true;
				break;
			}
		}
		if (!match && animatingToggle){
			animateLine(x1, y1, x2, y2);
		} else if (!match){
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
			if (testTurtle.getId().equals(turtleIDString) && !turtle.getIsVisible()){
				hideTurtle(testTurtle);
			}
			else if (testTurtle.getId().equals(turtleIDString) && animatingToggle){
				animateTurtle(testTurtle, turtleX, turtleY, turtleOrientation);
				match = true;
			} else if (testTurtle.getId().equals(turtleIDString) && !animatingToggle){
				setTurtle(testTurtle, turtleX, turtleY, turtleOrientation);
				match = true;
			}
		}
		if (!match){
			drawTurtle(turtleX, turtleY, turtleID, turtleOrientation);
		}
		
	}
	
	private void hideTurtle(Rectangle t){
		int index = myTurtles.indexOf(t);
		ImageView iv = myTurtleImageViews.get(index);
		iv.setOpacity(0);
	}
	
	private void drawLine(double x1, double y1, double x2, double y2){
		x1 += myPaneWidth/2; y1 = -y1 + myPaneHeight/2;
		x2 += myPaneWidth/2; y2 = -y2 + myPaneHeight/2;
		Line newLine = new Line(x1, y1, x2, y2);
		newLine.setStrokeWidth(myLineWidth);
		newLine.setStroke(myLineStroke);
		if (myDashArray.size() > 0){
			newLine.getStrokeDashArray().addAll(myDashArray);
			System.out.println(myDashArray);
			System.out.println("Is this love is this love is this love");
		}
		myLines.add(newLine);
		myLinePane.getChildren().add(newLine);
	}
	
	private void setTurtle(Rectangle t, double x, double y, double orientation){
		double leftX =  x + myPaneWidth/2 - myTurtleWidth/2;
		double topY = -y + myPaneHeight/2 - myTurtleHeight/2;
		t.setX(leftX);
		t.setY(topY);
		t.setRotate(90-orientation);
		setImageView(myTurtleImageViews.get(myTurtles.indexOf(t)), leftX, topY, orientation);
	}
	
	private void setImageView(ImageView iv, double leftX, double topY, double orientation){
		iv.setX(leftX);
		iv.setY(topY);
		iv.setRotate(90-orientation);
	}
	
	private Rectangle drawTurtle(double x, double y, double id, double orientation){
		Rectangle r = new Rectangle(x, y, myTurtleWidth, myTurtleHeight);
		r.setId(Double.toString(id));
		r.setFill(Color.TRANSPARENT);
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
	
	public void resetDisplay(){
		System.out.println("asdhasudhasiuldhasiufhealuivbaelbvuilasbia");
		myLines.clear();
		myLinePane.getChildren().clear();
		for (Rectangle turtle : myTurtles){
			setTurtle(turtle, initTurtleX, initTurtleY, myTurtleOrientationDefault);
		}
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
	
	public void setPenWidth(double width){
		myLineWidth = width;
	}
	
	public void setLineType(double lineType){
		myDashArray = new ArrayList<Double>();
		if (lineType == AppResources.DASHED_LINE_TYPE.getDoubleResource()){
			myDashArray.add(3*myLineWidth); myDashArray.add(3*myLineWidth);
		} else if (lineType == AppResources.DOTTED_LINE_TYPE.getDoubleResource()){
			myDashArray.add(myLineWidth); myDashArray.add(2*myLineWidth);
		}
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
	
	private boolean jumpAnimation(){
		int index = myAnimationQueue.size()-1;
		if (index >= 0){
			redrawAll(myAnimationQueue.get(index));
			myAnimationQueue.clear();
			return true;
		} else {
			return false;
		}
	}
	
	private class RunToggleEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
		    if (myAnimationTimeline.getStatus().equals(Animation.Status.RUNNING)) {
		    	setToRun = false;
		    	myAnimationTimeline.pause();
	        	runAnimationButton.setText(AppResources.RUN_TITLE.getResource());
	        } else if (myAnimationTimeline.getStatus().equals(Animation.Status.PAUSED)){
	        	myAnimationTimeline.play();
	        	setToRun = true;
	        	runAnimationButton.setText(AppResources.PAUSE_TITLE.getResource());
	        } else if (myAnimationTimeline.getStatus().equals(Animation.Status.STOPPED) && setToRun){
	        	setToRun = false;
	        	runAnimationButton.setText(AppResources.RUN_TITLE.getResource());
	        } else if (myAnimationTimeline.getStatus().equals(Animation.Status.STOPPED) && animatingToggle && !setToRun){
	        	myAnimationTimeline.play();
	        	setToRun = true;
	        	runAnimationButton.setText(AppResources.PAUSE_TITLE.getResource());
	        } else if (myAnimationTimeline.getStatus().equals(Animation.Status.STOPPED) && !setToRun){
	        	setToRun = true;
	        	runAnimationButton.setText(AppResources.PAUSE_TITLE.getResource());
	        }
		}
	}
	
	private class AnimationToggleEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
		   animatingToggle = !animatingToggle;
		   if (animatingToggle && setToRun){
			   myAnimationTimeline.play();
			   toggleAnimationButton.setText(AppResources.TOGGLE_OFF_TITLE.getResource());
			   runAnimationButton.setText(AppResources.PAUSE_TITLE.getResource());
		   } else if (animatingToggle && !setToRun){
			   toggleAnimationButton.setText(AppResources.TOGGLE_OFF_TITLE.getResource());
		   } else {
			   boolean successfulJump = jumpAnimation();
			   while (!successfulJump && myAnimationTimeline.getKeyFrames().size() > 1){
				   try {
					   Thread.sleep(250);
				   } catch (InterruptedException e) {
					   e.printStackTrace();
				   }
			   }
			   myAnimationTimeline.stop();
			   setToRun = false;
			   runAnimationButton.setText(AppResources.RUN_TITLE.getResource());
			   toggleAnimationButton.setText(AppResources.TOGGLE_ON_TITLE.getResource());
		   }
		}
	}
	
}
