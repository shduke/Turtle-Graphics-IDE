package view;

import javafx.scene.paint.Color;

/**
 * @author John Martin (jfm41)
 *
 */

public enum AppResources {
    APP_TITLE("SLogo 10"),
    APP_WIDTH(1300),
    APP_HEIGHT(700),
    APP_PADDING(25),
    APP_CSS("style.css"),
    
    CANVAS_WIDTH(675),
    CANVAS_HEIGHT(525),
    CANVAS_COLOUR(Color.LIGHTGREY),
    
    TURTLE_WIDTH(50),
    TURTLE_HEIGHT(65),
    TURTLE_FILL(Color.DARKSEAGREEN),
    LINE_STROKE(Color.BLUE),
    THIN_LINE_WIDTH(3),
    NORMAL_LINE_WIDTH(6),
    THICK_LINE_WIDTH(10),
    
    TOGGLE_ON_TITLE("Toggle (ON)"),
    TOGGLE_OFF_TITLE("Toggle (OFF)"),
    STEP_TITLE("Step"),
    RUN_TITLE("Run"),
    PAUSE_TITLE("Pause"),
    ANIMATION_SPEED(250),
    ANIMATION_MIN_RATE(0.25),
    ANIMATION_MAX_RATE(2.5),
    MILLI_PER_PX(5),
    
    LINE_LAYER_NUM(10),
    TURTLE_LAYER_NUM(20),
    INIT_TURTLE_ID(1),
    
    ANIMATION_BUTTON_WIDTH(160),
    ANIMATION_BUTTON_HEIGHT(55),
    
    DEFAULT_ERROR_MESSAGE("Error: "),
    ERROR_STRING("NO MATCH"),
    PATTERNS_STRING("expressions"),
    SLOGO_COMMANDS_URL("http://www.cs.duke.edu/courses/compsci308/fall16/assign/03_slogo/commands.php");
	

    private double resourceDouble;
    private String resourceString;
    private Color resourceColor;

    AppResources(String resource) {
        resourceString = resource;
        resourceDouble = -1;
    }

    AppResources(double resource) {
        resourceString = null;
        resourceDouble = resource;
        resourceColor = null;
    }
    
    AppResources(Color resource){
    	resourceString = null;
    	resourceDouble = -1;
    	resourceColor = resource;
    }

    public String getResource() {
        return resourceString;
    }

    public double getDoubleResource() {
        return resourceDouble;
    }
    
    public Color getColorResource(){
    	return resourceColor;
    }
}
