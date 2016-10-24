package cursor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreatedItem implements Drawable{
    List<Coordinate> myCoordinates;
    private Double myLayer;


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
    public List<Coordinate> getCreateItems () {
        return myCoordinates;
    }

    @Override
    public double getLayer () {
        return myLayer;
    }
}
