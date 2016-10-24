package cursor;

import java.util.List;

public interface Drawable {

    List<Coordinate> getCreateItems();
    double getLayer(); //maybe put layer as a third entry in Coordinate
}
