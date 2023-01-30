import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * CarContainer for mechanic.
 */
public class CarContainer implements Loadable<Car> {


    private Deque<Car> cars;

    public CarContainer(){
        this.cars = new LinkedList();
    }

    /**
     * Unloads the last car which entered the platform.

     * @return Car which was unloaded.
     */
    @Override
    public Car unload() {
        Car car = this.cars.poll();//First in last out
        return car;
    }

    /**
     *
     * Load something unto the ramp platform.
     *
     * @param o The object to be loaded
     * @throws IllegalArgumentException Throws IllegalArgExc. when a certain type isn't allowed to be loaded.  Or the car being loaded is too far away from the ramp.
     */
    @Override
    public void load(Car o) throws IllegalArgumentException{
        if(this.isDisallowed(o)){
            throw new IllegalArgumentException("Cannot load a TransportTruck unto this platform.");
        }
        //if(distance >5){//Can not load unless distance is less than 5 (car being loaded must be near)
       //     throw new IllegalArgumentException("The car is too far away o be loaded");
        //}
        this.cars.add(o);
    }

    @Override
    public boolean isDisallowed(Car t) {
        return false;
    }

}
