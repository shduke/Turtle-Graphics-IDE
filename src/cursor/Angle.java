package cursor;

public class Angle {

    double myAngle;
    
    Angle(double degrees) {
        setAngle(degrees);
    }
    
    public void rotate(double degrees) {
        setAngle(myAngle + degrees);
    }
   
    private double reduceAngle(double angle) {
        return ((angle % 360) + 360) % 360;
    }
    
    public double setAngle(double angle) {
        double difference = reduceAngle(angle) - myAngle;
        myAngle  = reduceAngle(angle);
        return difference;
    }
    
    public double setAngle(double x, double y) {
        return setAngle(reduceAngle(Math.toDegrees(Math.atan(y / x))));
    }
    
    public double getAngle() {
        return myAngle;
    }
}
