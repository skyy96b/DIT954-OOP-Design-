package src.main.java.View;

import src.main.java.Model.Car;

import java.util.List;
import java.util.Map;

public interface SpeedObserver {

    /**
     * Update on speed change
     *
     * @param cars List of entries representing car and speed. Some of which are updated.
     */
    void onSpeedChange(List<Map.Entry<String, Double>> cars);
}
