package view.xml;

import view.xml.TurtleXMLModel;

import org.w3c.dom.Element;

import java.util.Objects;


/**
 * An XMLFactory that gives back a Person object.
 *
 * @author Rhondu Smithwick
 * @author Robert Duvall
 */
public class TurtleXMLFactory extends XMLFactory {
    private String myPersonType;


    /**
     * Create a factory for making Person objects.  
     */
    public TurtleXMLFactory () {
    }

    /**
     * @return the type of person this file represents
     */
    public String getPersonType () {
        return myPersonType;
    }

    /**
     * Get the actual person contained in this XML File.
     */
    public TurtleXMLModel getTurtle (Element root) throws XMLFactoryException {
        if (! isValidFile(root)) {
            throw new XMLFactoryException("XML file does not represent a %s", getPersonType());
        }
        String backgroundColor = getTextValue(root, "backgroundColor");
        String numberTurtles = getTextValue(root, "numberTurtles");
        String penColor = getTextValue(root, "penColor");
        return new TurtleXMLModel(backgroundColor, numberTurtles, penColor);
    }

    /**
     * @see XMLFactory#isValidFile()
     */
    @Override
    protected boolean isValidFile (Element root) {
        return Objects.equals(getAttribute(root, "PersonType"), getPersonType());
    }
}
