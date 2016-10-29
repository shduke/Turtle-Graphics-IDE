package cursor;

public class Pen {
    boolean myIsPenDown;
    double myThickness;
    String myColor;
    
    Pen () {
        myIsPenDown = true;
        myThickness = 10;
        myColor = "Black";
    }

    public boolean getIsPenDown () {
        return myIsPenDown;
    }

    public boolean setIsPenDown(double isPenDown) {
        return setIsPenDown(isPenDown == 1 ? true : false);
    }
    
    public boolean setIsPenDown (boolean isPenDown) {
        myIsPenDown = isPenDown;
        return isPenDown;
    }
    
    
}
