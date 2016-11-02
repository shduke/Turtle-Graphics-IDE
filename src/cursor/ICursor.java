package cursor;

import java.util.List;
import java.util.Observable;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import command.utility.Constant;


public interface ICursor {

    Coordinate getCoordinate ();

    double getOrientation ();

    Angle getAngle ();
    
    //Function<Double, Double> getAngleFunction(double degrees);
    
    double clearCreatedItems ();

    List<IDrawable> getDrawableItems();

    double move (double distance);

    boolean getIsVisible ();

    boolean setIsVisible (Boolean isVisible);

    Pen getPen ();

    boolean getIsActive ();

    double setIsActive (boolean isActive);

    double getId();
    
    double getNumberOfTurtles();
    
    double activateCursors(List<Double> turtles);
    
    Constant[] getActiveCursorConstants();
}
