package cursor;

import java.util.List;
import java.util.function.Function;
import command.utility.Constant;

/**
 * @author Sean Hudson (srh50)
 */
public interface ICursor {

    /**
     * Gets Cursor's coordinate
     * @return
     */
    Coordinate getCoordinate ();

    /**
     * Gets Cursor's angle
     * @return
     */
    double getOrientation ();

    /**
     * Gets Cursor's Angle delegate
     * @return
     */
    Angle getAngle ();

    /**
     * Clears all of Cursor's created items
     * @return
     */
    double clearCreatedItems ();

    /**
     * Get all of the drawable items belonging to this Cursor
     * @return
     */
    List<IDrawable> getDrawableItems ();

    /**
     * Move the Cursor
     * 
     * @param distance
     * @return 
     */
    double move (double distance);

    /**
     * Gets if the Cursor is visible or not
     * @return
     */
    boolean getIsVisible ();

    /**
     * Sets Cursor's visibility
     * 
     * @param isVisible
     * @return
     */
    boolean setIsVisible (Boolean isVisible);

    /**
     * Gets Cursor's Pen delegate
     * @return
     */
    Pen getPen ();

    /**
     * Gets if the Cursor is active
     * @return
     */
    boolean getIsActive ();

    /**
     * Set the Cursor to active or inactive
     * @return
     */
    double setIsActive (boolean isActive);

    /**
     * Gets Cursor's id
     * @return
     */
    double getId ();

    /**
     * Gets number of Cursors
     * @return
     */
    double getNumberOfTurtles ();

    /**
     * Activtes Cursors
     * @param turtles
     * @return
     */
    double activateCursors (List<Double> turtles);

    /**
     * gets a Constant Array representing the current active Cursors
     * 
     * @return
     */
    Constant[] getActiveCursorConstants ();

    /**
     * Applies a function to all of the active Cursors
     * @param mapping
     * @return
     */
    <E> E applyToActive (Function<ICursor, E> mapping);

    /**
     * Sets the background color
     * @param background
     * @return
     */
    double setBackground (double background);

    /**
     * Sets the Cursor's shape 
     * @param shape
     * @return
     */
    double setShape (double shape);

    /**
     * Gets the Cursor's shape
     * @return
     */
    double getShape ();

    /**
     * Sets the Palette
     * @return
     */
    Double setPalette (Double index, String color);

}
