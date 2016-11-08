package cursor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Sean Hudson (srh50)
 */
public class CreatedItem implements IDrawable{
    private static final double DEFAULT_ORIENTATION = 90;
    private static final double DEFAULT_LAYER = 10;
    private static final double DEFAULT_ID = 0;
    private static final boolean DEFAULT_IS_VISIBLE = true;
    private List<ICoordinate> myCoordinates;
    private double myColor;
    private double mySize;


    CreatedItem (double color, double size, Coordinate ... coordinates) {
        myCoordinates = new ArrayList<ICoordinate>(Arrays.asList(coordinates));
        myColor = color;
        mySize = size;
    }


    @Override
    public List<ICoordinate> getDrawableCoordinates () {
        return Collections.unmodifiableList(myCoordinates);
    }


    @Override
    public double getOrientation () {
        return DEFAULT_ORIENTATION;
    }


    @Override
    public double getLayer () {
        return DEFAULT_LAYER;
    }


    @Override
    public boolean getIsVisible () {
        return DEFAULT_IS_VISIBLE;
    }


    @Override
    public double getId () {
        return DEFAULT_ID;
    }


    @Override
    public double getColor () {
        return myColor;
    }


    @Override
    public double getSize () {
        return mySize;
    }
    
}