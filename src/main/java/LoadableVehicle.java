package src.main.java;

import java.awt.*;

/**
 * Vehicle which is loadable. I.e a transporter of some kind
 *
 * All vehicles should be transportable. Because there is always something that can transport another vehicle.
 * A loadable vehicle can transport other vehicles..
 *
 * Use for Ferry & Transportertruck later
 *
 * TODO fill in
 *
 * @param <T>
 */
public class LoadableVehicle<T> extends Vehicle implements Loadable<T>{
    /**
     * @param dir Starting direction of Vehicle
     * @param pos Starting position of vehicle.
     */
    public LoadableVehicle(Direction dir, Point pos) {
        super(dir, pos);
    }

    @Override
    public T unload() {
        return null;
    }

    @Override
    public void load(T t) {

    }

    @Override
    public boolean isDisallowed(T t) {
        return false;
    }
}
