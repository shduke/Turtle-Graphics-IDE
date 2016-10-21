package view;

public enum AppResources {
    APP_TITLE("SLogo 10"),
    APP_WIDTH(1200),
    APP_HEIGHT(650),
    APP_PADDING(25),
    APP_CSS("style.css"),
    
    CANVAS_WIDTH(700),
    CANVAS_HEIGHT(575),
    
    TURTLE_WIDTH(50),
    TURTLE_HEIGHT(50);


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
