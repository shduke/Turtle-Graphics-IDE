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
    Map<Double, String> myColorPalette;
    Pen myPen;
    double myBackground;
    int myNextCursorId;

    public CursorManager () {
        // myCursors = new HashSet<ICursor>();
        myCursors = new HashMap<Double, ICursor>();
        myActiveCursorStack = new Stack<Map<Double,Boolean>>();
        myColorPalette = new HashMap<Double, String>();
        myNextCursorId = 0;
        myPen = new Pen();
        createTurtle(1);
    }
    
    @Override
    public Coordinate getCoordinate () {
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
    public double move (double distance) {
        //return evaluateStream(ICursor::getIsActive, a -> a.move(distance));
        return applyToActive(a -> a.move(distance));
    }
    
//    public <E, R> Function<E, R> applyCommand(Function<ICursor,R> mapping) {
//        return a -> applyToActive(mapping);
//    }
    
    public <E> E applyToActive(Function<ICursor, E> mapping) {
        return evaluateStream(ICursor::getIsActive, mapping);
    }
    
    private <E> E evaluateStream(Predicate<ICursor> filter, Function<ICursor, E> mapping) {
        return myCursors.values().stream().filter(filter).map(mapping).reduce((a, b) -> b).get();
    }

    @Override
    public double clearCreatedItems () {
        return applyToActive(ICursor::clearCreatedItems);
    }

    @Override
    public List<IDrawable> getDrawableItems () {
        List<IDrawable> drawableItems = new ArrayList<IDrawable>();
        myCursors.values().stream().forEach(p -> drawableItems.addAll(p.getDrawableItems()));
        return drawableItems;
    }
    

    @Override
    public boolean getIsVisible () {
        return applyToActive(ICursor::getIsVisible);
    }

    @Override
    public boolean setIsVisible (Boolean isVisible) {
        return applyToActive(a -> a.setIsVisible(isVisible));
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
        //return evaluateStream(a -> true, a -> a.setIsActive(true));
        return applyToActive(a -> a.setIsActive(true));
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
        myCursors.put(id, new Cursor(id, myPen));
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
    public double setBackground(double background) {
        myBackground = background;
        return background;
    }

    @Override
    public double setShape (double shape) {
        return applyToActive(a -> a.setShape(shape));
    }

    @Override
    public double getShape () {
        return applyToActive(a -> a.getShape());
    }

    @Override
    public Double setPalette (Double index, String color) {
        myColorPalette.put(index, color);
        return index; 
    }

    @Override
    public Map<Double, String> getPalette () {
        return myColorPalette;
    }


}
