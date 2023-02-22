package src.main.java.Model;

import java.awt.*;

public interface PositionObserver {

    /**
     * Updated each time the observed thing's position is updated
     * @param point
     */
    public void onPositionUpdate(Point point);

}
