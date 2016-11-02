package cursor;

import java.util.List;

public interface IDrawable { //TODO - maybe refactor to 

    List<ICoordinate> getDrawableCoordinates();
    
    double getOrientation();
    
    double getLayer(); //maybe put layer as a third entry in Coordinate
    
    boolean getIsVisible();
    
    double getId();
    
    double getColor();
    
    double getSize();
}
