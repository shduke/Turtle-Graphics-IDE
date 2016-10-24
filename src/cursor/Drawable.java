package cursor;

import java.util.List;

public interface Drawable { //TODO - maybe refactor to 

    List<Coordinate> getCreateItems();
    double getLayer(); //maybe put layer as a third entry in Coordinate
    double getOrientation();
    boolean getIsVisible();
}
