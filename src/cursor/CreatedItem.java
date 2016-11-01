package cursor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreatedItem implements Drawable{
    List<Coordinate> myCoordinates;
    private Double myLayer;
    private Double myOrientation;


    CreatedItem(Coordinate...coordinates) {
        myCoordinates = new ArrayList<Coordinate>(Arrays.asList(coordinates));
        myLayer = 10.0;
    }
    
    public List<Coordinate> getCoordinates () {
        return myCoordinates;
    }

    public void setCoordinates (List<Coordinate> myCoordinates) {
        this.myCoordinates = myCoordinates;
    }

    @Override
    public List<ICoordinate> getCreateItems () {
        List<ICoordinate> copyCoordinates = new ArrayList<ICoordinate>();
        return copyCoordinates;
    }

    @Override
    public double getLayer () {
        return myLayer;
    }

    @Override
    public double getOrientation () {
        return myLayer;
    }

    @Override
    public boolean getIsVisible () {
        return true;
    }
}
