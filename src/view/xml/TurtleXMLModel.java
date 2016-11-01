package view.xml;

/**
 * A value object for a Turtle.
 *
 * @author Rhondu Smithwick
 * @author Robert Duvall
 */
public class TurtleXMLModel {
    private String myBackgroundColor;
	private String myNumberTurtles;
    private String myPenColor;

    public TurtleXMLModel (String backgroundColor, String numberTurtles, String penColor) {
        myBackgroundColor = backgroundColor;
        myNumberTurtles = numberTurtles;
        myPenColor = penColor;
    }

    public String getBackgroundColor() {
		return myBackgroundColor;
	}

	public String getNumberTurtles() {
		return myNumberTurtles;
	}

	public String getPenColor() {
		return myPenColor;
	}
}
