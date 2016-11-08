package cursor;

import java.util.List;

/**
 * @author Sean Hudson (srh50)
 */
public interface IDrawable {

    /**
     * Gets all of the coordinates that make up the drawable item
     * @return
     */
    List<ICoordinate> getDrawableCoordinates ();

    /**
     * Gets the angle of the Cursor
     * @return
     */
    double getOrientation ();

    /**
     * Gets the layer that the Cursor belongs on
     * @return
     */
    double getLayer ();

    /**
     * Gets if the Cursor is visible or not
     * @return
     */
    boolean getIsVisible ();

    /**
     * Gets Cursor's id
     * @return
     */
    double getId ();

    /**
     * Gets if the Cursor's color
     * @return
     */
    double getColor ();

    /**
     * Gets if the Cursor's size
     * @return
     */
    double getSize ();

}
