package cursor;

import java.util.List;


public interface IDrawable {

    List<ICoordinate> getDrawableCoordinates ();

    double getOrientation ();

    double getLayer ();

    boolean getIsVisible ();

    double getId ();

    double getColor ();

    double getSize ();

}
