package cursor;

import java.util.List;

public interface ICursorManagerDisplay {
    
    List<IDrawable> getDrawableItems();
    
    IPen getPen();
    
    double getBackGround();
    
}
