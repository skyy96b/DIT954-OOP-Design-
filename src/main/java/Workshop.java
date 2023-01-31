package src.main.java;
import java.util.*;

/**
 * Workshop
 */
public class Workshop<T extends Car> implements Loadable<T> {

    private int capacity;

    private List<T> cars;

    public Workshop(int capacity){
        this.cars = new ArrayList<>();
        this.capacity = capacity;
    }

    private int fetchNext = 0;

    /**
     * Tells the Workshop which car to unload next . When
     * using {@link #unload()}
     * @param id
     */
    public void setNextCarToFetch(int id){
        this.fetchNext = id;
    }

    /**
     * Unloads the car which was told to be fetched by {@link #setNextCarToFetch(int)}.
     *
     * @return Car which was unloaded. May return null.
     */
    @Override
    public T unload() {//T represents the most specific static type
        return this.cars.get(this.fetchNext);
    }



    /**
     *
     * Load something unto the ramp platform.
     *
     * @param o The object to be loaded
     * @throws IllegalArgumentException Throws IllegalArgExc. when a certain type isn't allowed to be loaded.  Or the car being loaded is too far away from the ramp.
     */
    @Override
    public void load(T o) throws IllegalArgumentException{
        if(o == null) return;

        if(this.isDisallowed(o)){
            throw new IllegalArgumentException("Cannot load a TransportTruck unto this platform.");
        }

        if(this.cars.size() >= this.capacity){
            throw new IllegalArgumentException("The workshop is full!");
        }

        this.cars.add(o);
    }

    @Override
    public boolean isDisallowed(Car t) {
        return false;
    }

}
