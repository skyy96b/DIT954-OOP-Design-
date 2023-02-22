package src.main.java.View;

public interface ObservableSpeedChange {

    void addSpeedChangeListener(SpeedObserver observer);
    void removeSpeedChangeListener(SpeedObserver observer);
    void notifySpeedChangeListeners();


}

