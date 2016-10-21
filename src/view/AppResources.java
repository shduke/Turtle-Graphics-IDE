package view;

public enum AppResources {
    APP_TITLE("SLogo 10"),
    APP_WIDTH(1200),
    APP_HEIGHT(650),
    APP_PADDING(25),
    APP_CSS("style.css"),
    
    CANVAS_WIDTH(700),
    CANVAS_HEIGHT(545),
    
    TURTLE_WIDTH(50),
    TURTLE_HEIGHT(50),
    
    DEFAULT_ERROR_MESSAGE("Error: "),
    ERROR_STRING("NO MATCH"),
    PATTERNS_STRING("expressions"),
    SLOGO_COMMANDS_URL("http://www.cs.duke.edu/courses/compsci308/fall16/assign/03_slogo/commands.php");
	

    private double resourceDouble;
    private String resourceString;

    AppResources(String resource) {
        resourceString = resource;
        resourceDouble = -1;
    }

    AppResources(double resource) {
        resourceString = null;
        resourceDouble = resource;
    }

    public String getResource() {
        return resourceString;
    }

    public double getDoubleResource() {
        return resourceDouble;
    }
}
