package cursor;

/**
 * @author Sean Hudson (srh50)
 */
public interface IPen {

    /**
     * Gets Pen's size
     * @return
     */
    double getPenSize ();

    /**
     * Gets Pen's color
     * @return
     */
    double getPenColor ();

    /**
     * Gets if the pen is down or not
     * @return
     */
    boolean getIsPenDown ();

    /**
     * sets Pen's size
     * @return
     */
    double setPenSize (double penSize);

    /**
     * sets Pen's color
     * @return
     */
    double setPenColor (double color);

}
