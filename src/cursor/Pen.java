package cursor;

public class Pen implements IPen{
    private static final double DEFAULT_SIZE = 10;
    private static final double DEFAULT_COLOR = 0;
    private static final boolean DEFAULT_IS_PEN_DOWN = true;

    
    boolean myIsPenDown;
    double myPenSize;
    double myColor;
    
    Pen () {
        myIsPenDown = DEFAULT_IS_PEN_DOWN;
        myPenSize = DEFAULT_SIZE;
        myColor = DEFAULT_COLOR;
    }

    public boolean getIsPenDown () {
        return myIsPenDown;
    }

    public boolean setIsPenDown(double isPenDown) {
        return setIsPenDown(isPenDown == 1 ? true : false);
    }
    
    public boolean setIsPenDown (boolean isPenDown) {
        myIsPenDown = isPenDown;
        System.out.println(myIsPenDown);
        return isPenDown;
    }

    @Override
    public double getPenSize () {
        return myPenSize;
    }

    @Override
    public double getPenColor () {
        return myColor;
    }

    @Override
    public double setPenSize (double penSize) {
        myPenSize = penSize;
        return penSize;
    }

    @Override
    public double setPenColor (double color) {
        myColor = color;
        return color;
    }
    
    
}
