package src.main.java.Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Being an observable position
 * In the future one might want to have different vehicles which have observablepositions.
 */
public class ObservablePosition implements IObservablePosition{

    List<PositionObserver> observers;

    public ObservablePosition(){
        observers = new ArrayList<>();
    }

    public void addObserver(PositionObserver positionObserver){
        this.observers.add(positionObserver);
    }

    public void deleteObserver(PositionObserver positionObserver){
        this.observers.remove(positionObserver);
    }

    public void notifyObservers(Point newPosition){
        for(PositionObserver observer: observers){
            observer.onPositionUpdate(newPosition);
        }
    }

}
