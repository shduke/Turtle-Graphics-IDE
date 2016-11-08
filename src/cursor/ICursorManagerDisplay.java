package cursor;

/**
 * @author Sean Hudson (srh50)
 */
import java.util.List;
import java.util.Map;

public interface ICursorManagerDisplay {
    
    List<IDrawable> getDrawableItems();
    
    IPen getPen();
    
    double getBackGround();
    
    Map<Double, String> getPalette();
}
