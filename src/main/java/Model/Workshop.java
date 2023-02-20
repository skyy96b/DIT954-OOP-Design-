package src.main.java.Model;
import java.util.*;

/**
 * Workshop
 */
public class Workshop<T extends Car> implements Loadable<T> {

    private int capacity;

    private Map<T, T> cars;//We see the key (the car object) as having the key to fetch out the car in the workshop

    public Workshop(int capacity){
        this.cars = new HashMap<>();
        this.capacity = capacity;
    }

    private T fetchNext = null;

    /**
     * Tells the Workshop which car to unload next . When
     * using {@link #unload()}
     * @param toFetch The car to fetch next from the workshop
     */
    public void setNextCarToFetch(T toFetch){
        this.fetchNext = toFetch;
    }

    /**
     * Unloads the car which was told to be fetched by {@link #setNextCarToFetch(T)}.
     *
     * @return Car which was unloaded. May return null.
     */
    @Override
    public T unload() {//T represents the most specific static type
        if(this.fetchNext == null) throw new IllegalArgumentException("Cannot unload NULL.");
        return this.cars.remove(this.fetchNext);
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

        this.cars.put(o,o);
    }

    @Override
    public boolean isDisallowed(Car t) {
        return false;
    }

}
