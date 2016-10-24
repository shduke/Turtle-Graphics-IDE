package view;

import javafx.scene.paint.Color;

public enum AppResources {
    APP_TITLE("SLogo 10"),
    APP_WIDTH(1300),
    APP_HEIGHT(700),
    APP_PADDING(25),
    APP_CSS("style.css"),
    
    CANVAS_WIDTH(700),
    CANVAS_HEIGHT(545),
    
    TURTLE_WIDTH(50),
    TURTLE_HEIGHT(50),
    TURTLE_FILL(Color.DARKSEAGREEN),
    LINE_STROKE(Color.ALICEBLUE),
    LINE_WIDTH(3),
    
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
