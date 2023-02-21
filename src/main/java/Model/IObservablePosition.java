package src.main.java.Model;

import java.awt.*;

public interface IObservablePosition {


    public void addObserver(PositionObserver positionObserver);

    public void deleteObserver(PositionObserver positionObserver);

    public void notifyObservers(Point newPosition);

}
