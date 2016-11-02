package cursor;

import java.util.List;
import java.util.function.Function;
import command.utility.Constant;


public interface ICursor {

    Coordinate getCoordinate ();

    double getOrientation ();

    Angle getAngle ();

    double clearCreatedItems ();

    List<IDrawable> getDrawableItems ();

    double move (double distance);

    boolean getIsVisible ();

    boolean setIsVisible (Boolean isVisible);

    Pen getPen ();

    boolean getIsActive ();

    double setIsActive (boolean isActive);

    double getId ();

    double getNumberOfTurtles ();

    double activateCursors (List<Double> turtles);

    Constant[] getActiveCursorConstants ();

    <E> E applyToActive (Function<ICursor, E> mapping);

    double setBackground (double background);

    double setShape (double shape);

    double getShape ();

    Double setPalette (Double index, String color);

}
