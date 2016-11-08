package cursor;

/**
 * @author Sean Hudson (srh50)
 */
public class Angle {
    private static final double DEFAULT_ORIENTATION = 90;
    private static final double ANGLE_SIGN_OFFSET = 0.5;
    double myAngle;

    Angle (double degrees) {
        setAngle(degrees);
    }

    Angle () {
        this(DEFAULT_ORIENTATION);
    }

    public double rotate (double degrees) {
        setAngle(myAngle + degrees);
        return Math.abs(degrees);
    }

    private double reduceAngle (double angle) {
        return ((angle % 360) + 360) % 360;
    }

    public double setAngle (double angle) {
        double difference = reduceAngle(angle) - myAngle;
        myAngle = reduceAngle(angle);
        return difference * getAngleSign(angle);
    }

    public double setAngle (double x, double y) {
        return setAngle(reduceAngle(Math.toDegrees(Math.atan2(y, x))));
    }

    private double getAngleSign (double angle) {
        return Math.signum(Math.signum(angle) + ANGLE_SIGN_OFFSET);
    }

    public double getAngle () {
        return myAngle;
    }
}
