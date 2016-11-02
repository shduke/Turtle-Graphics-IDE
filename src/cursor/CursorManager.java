package cursor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import command.AbstractCommand;
import command.utility.Constant;


public class CursorManager implements ICursor, ICursorManagerDisplay {
    // Set<ICursor> myCursors;
    Map<Double, ICursor> myCursors;
    Stack<Map<Double, Boolean>> myActiveCursorStack;
    Pen myPen;
    double myBackground;
    int myNextCursorId;

    public CursorManager () {
        // myCursors = new HashSet<ICursor>();
        myCursors = new HashMap<Double, ICursor>();
        myActiveCursorStack = new Stack<Map<Double,Boolean>>();
        myNextCursorId = 0;
        myPen = new Pen();
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
        return null;
    }

    @Override
    public double clearCreatedItems () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<IDrawable> getDrawableItems () {
        List<IDrawable> drawableItems = new ArrayList<IDrawable>();
        myCursors.values().stream().forEach(p -> drawableItems.addAll(p.getDrawableItems()));
        return drawableItems;
    }
    
    private double evaluateStream(Predicate<ICursor> filter, Function<ICursor, Double> mapping) {
        return myCursors.values().stream().filter(filter).map(mapping).reduce((a, b) -> b).get();
    }
    
    @Override
    public double move (double distance) {
        return evaluateStream(ICursor::getIsActive, a -> a.move(distance));
//        return myCursors.values().stream().filter(a -> a.getIsActive()).map(a -> a.move(distance))
//                .reduce( (a, b) -> b).get();
    }

    @Override
    public boolean getIsVisible () {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean setIsVisible (Boolean isVisible) {
        //return evaluateStream(a -> true, a -> a.setIsVisible(true)) == 1 ? true : false;
        return false;
    }

    @Override
    public Pen getPen () {
        return myPen;
    }

    @Override
    public boolean getIsActive () {
        return true;
    }

    @Override
    public double setIsActive (boolean isActive) {// TODO: is this a bad design to have this do
        return evaluateStream(a -> true, a -> a.setIsActive(true));
    }

    
    @Override
    public double getId () {
        return evaluateStream(ICursor::getIsActive, ICursor::getId);
    }

    @Override
    public double getNumberOfTurtles () {
        return myCursors.size();
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

    private void deactivateCursors() {
        evaluateStream(a -> true, a -> a.setIsActive(false));
    }
    
//    public Map<Double, Boolean> copyMap() {
//        return
//                myCursors.entrySet().stream().filter(a -> a.getValue().getIsActive())
//                    .collect(Collectors.toMap(
//                        a -> a.getKey(),
//                        a -> true
//                    ));
//    }
    
    private Map<Double, Boolean> copyMap() {
        return myCursors.entrySet().stream().filter(a -> a.getValue().getIsActive()).collect(Collectors.toMap(Entry::getKey, p -> true));
        
    }
    
    public Constant[] getActiveCursorConstants() {
        return copyMap().keySet().stream().map(Constant::new).toArray(Constant[]::new);
    }
    
//    private void reinstateMap(Map<Double, Boolean> copyMap) {
//        deactivateCursors();
//        copyMap.keySet().stream().forEach(a -> myCursors.get(a).setIsActive(true));
//    }
//    
//    
//    public void store(List<Double> cursors) {
//        myActiveCursorStack.push(copyMap());
//        createCursors(cursors);
//    }
//    
//    public void restore() {
//        reinstateMap(myActiveCursorStack.pop());
//    }
    
    private double createCursors(List<Double> cursors) {
        return cursors
                .stream().map(a -> (myCursors.containsKey(a) ? myCursors.get(a).setIsActive(true)
                                                             : createTurtle(a)))
                .reduce( (a, b) -> b).get();
    }
    
//    private List<Double> getCursorsWithCondition(AbstractCommand command) {
//        Map<Double>
//        myCursors.entrySet().stream().filter(predicate)
//    }
    
    @Override
    public double activateCursors (List<Double> cursors) {
        deactivateCursors();
        return createCursors(cursors);
    }


    @Override
    public double getBackGround () {
        return myBackground;
    }

    @Override
    public void setBackground (double background) {
        myBackground = background;
    }


}
