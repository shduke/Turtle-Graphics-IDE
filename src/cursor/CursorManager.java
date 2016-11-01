package cursor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class CursorManager implements ICursor, Observer {
    // Set<ICursor> myCursors;
    Map<Double, ICursor> myCursors;
    int myNextCursorId;

    public CursorManager () {
        // myCursors = new HashSet<ICursor>();
        myCursors = new HashMap<Double, ICursor>();
        myNextCursorId = 0;
        createTurtle(1);
    }

    @Override
    public Coordinate getCoordinate () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getOrientation () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Angle getAngle () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double clearCreatedItems () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void createItem (Coordinate nextCoordinate) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<ICoordinate> getCreateItems () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double move (double distance) {
        return myCursors.values().stream().filter(a -> a.getIsActive()).map(a -> a.move(distance))
                .reduce( (a, b) -> b).get();
    }

    @Override
    public boolean getIsVisible () {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean setIsVisible (Boolean isVisible) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Pen getPen () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getLayer () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void update (Observable o, Object arg) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean getIsActive () {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public double setIsActive (boolean isActive) {// TODO: is this a bad design to have this do
                                                  // nothing?
        return 0;
    }

    @Override
    public double getId () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getNumberOfTurtles () {
        // TODO Auto-generated method stub
        return 0;
    }

    private double createTurtle (double id) {
        myCursors.put(id, new Cursor(id));
        myNextCursorId++;
        return id;
    }

    // private double createTurtle(double id) {
    // IntStream.rangeClosed(myNextCursorId, endInclusive)
    // Math.round(id);
    // myCursors.put(id, new Cursor(id));
    // myNextCursorId++;
    // return id;
    // }

    @Override
    public double activateCursors (List<Double> turtles) {
        return turtles
                .stream().map(a -> (myCursors.containsKey(a) ? myCursors.get(a).setIsActive(true)
                                                             : createTurtle(a)))
                .reduce( (a, b) -> b).get();
    }

}
