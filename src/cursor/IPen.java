package cursor;

public interface IPen {

    double getPenSize();
    
    double getPenColor();
        
    boolean getIsPenDown();
    
    void setPenSize(double penSize);
    
    void setPenColor(double color);
    
}
