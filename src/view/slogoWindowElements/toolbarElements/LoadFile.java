/**
 * 
 */
package view.slogoWindowElements.toolbarElements;

import java.io.File;

import view.xml.TurtleXMLModel;
import view.xml.TurtleXMLFactory;
import view.xml.XMLFactoryException;
import view.xml.XMLParser;

/**
 * @author Noel Moon (nm142)
 *
 */
public class LoadFile {
	
	public final static String XML_FILES_LOCATION = "data/xml/";
	private static final String XML_SUFFIX = ".xml";

	private String myBackgroundColor;
	private String myNumberTurtles;
    private String myPenColor;
	
	public LoadFile() {
		loadFile();
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
	
	private void loadFile() {
		XMLParser parser = new XMLParser();
	    TurtleXMLFactory factory = new TurtleXMLFactory();
	    File folder = new File(XML_FILES_LOCATION);
	    for (File f : folder.listFiles()) {
	        if (f.isFile() && f.getName().endsWith(XML_SUFFIX)) {
	            try {
	                TurtleXMLModel p = factory.getTurtle(parser.getRootElement(f.getAbsolutePath()));
	                myBackgroundColor = p.getBackgroundColor();
	                myNumberTurtles = p.getNumberTurtles();
	                myPenColor = p.getPenColor();
	            }
	            catch (XMLFactoryException e) {
	                System.err.println("Reading file " + f.getPath());
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
}
