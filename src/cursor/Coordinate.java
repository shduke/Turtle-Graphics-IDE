package cursor;

import java.util.Observable;

/**
 * Creates a coordinate class to utilize in the map of cells inside of the grid
 * 
 * @author Sean Hudson
 *
 */
public class Coordinate extends Observable implements ICoordinate {
    private static final double DEFAULT_X_COORDINATE = 0;
    private static final double DEFAULT_Y_COORDINATE = 0;
    private double myX;
    private double myY;

    public Coordinate (double x, double y) {
        myX = x;
        myY = y;
    }
    
    public Coordinate () {
        this(DEFAULT_X_COORDINATE, DEFAULT_Y_COORDINATE);
    }

    
    public double setCoordinate(double x, double y) {
        setChanged();
        notifyObservers(new double[]{myX, myY, x, y});
        double distance = calculateDistance(x, y);
        myX = x;
        myY = y;
        System.out.println(this);
        return distance;
    }
    
    /**
     * Add x coordinate and myX and y coordinate and myY to produce new coordinate
     * 
     * @param coordinate
     * @return
     */
//    public double add (Coordinate coordinate) {
//        return setCoordinate(coordinate.getX(), coordinate.getY());
//    }

    /**
     * Subtract x coordinate and myX and y coordinate and myY to produce new coordinate
     * 
     * @param coordinate
     * @return
     */
    public double subtract (Coordinate coordinate) {
        return setCoordinate(myX -= coordinate.getX(), myY -= coordinate.getY());
    }

    /**
     * Determine scale factor for coordinate
     * 
     * @param scaleFactor
     * 
     */
    public double scale (double scaleFactor) {
        return setCoordinate(myX *= scaleFactor, myY *= scaleFactor);
    }

    /**
     * Translates the coordinates to a new location
     * 
     * @param distance
     * @param angle
     * @return
     */
    public double translate (double distance, double angle) {
        return setCoordinate(myX + Math.cos(Math.toRadians(angle)) * distance, myY + Math.sin(Math.toRadians(angle)) * distance);
    }
    
    
//    public double calculateDistance(Coordinate coordinate) {
//        return Math.sqrt(Math.pow(coordinate.getX() - myX, 2) + Math.pow(coordinate.getY() - myY, 2));
//    }
    
    public double calculateDistance(double x, double y) {
        return Math.sqrt(Math.pow(x - myX, 2) + Math.pow(y - myY, 2));
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Coordinate)) {
            return false;
        }
        return (myX == ((Coordinate) obj).getX()) && (myY == ((Coordinate) obj).getY());
    }

    /**
     * return hashCode for the coordinate
     */
    @Override
    public int hashCode () {
        return (int) (myX + (myY + (((myX + 1) / 2) * ((myX + 1) / 2))));
    }

    /**
     * 
     * @return x coordinate
     */
    public double getX () {
        return myX;
    }

    /**
     * 
     * @return y coordinate
     */
    public double getY () {
        return myY;
    }

    @Override
    public String toString () {
        return myX + ", " + myY;
    }

}
