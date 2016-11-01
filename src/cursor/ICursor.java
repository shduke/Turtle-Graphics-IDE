package cursor;

import java.util.List;
import java.util.Observable;
import java.util.Set;
import java.util.function.Consumer;


public interface ICursor {

    Coordinate getCoordinate ();

    double getOrientation ();

    Angle getAngle ();

    double clearCreatedItems ();

    void createItem (Coordinate nextCoordinate);

    List<ICoordinate> getCreateItems ();

    double move (double distance);

    boolean getIsVisible ();

    boolean setIsVisible (Boolean isVisible);

    Pen getPen ();

    double getLayer ();

    void update (Observable o, Object arg);

    boolean getIsActive ();

    double setIsActive (boolean isActive);

    double getId();
    
    double getNumberOfTurtles();
    
    double activateCursors(List<Double> turtles);
}
