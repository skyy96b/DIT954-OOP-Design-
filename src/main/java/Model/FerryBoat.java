package src.main.java.Model;
import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

public class FerryBoat<T extends Car> extends Vehicle implements ITransporter<T> {//Moveable & Loadable in common between Ferry and TransportTruck

    private IObservablePosition observablePosition = new ObservablePosition();

    private int capacity;

    private Deque<T> cars;

    public FerryBoat(Direction dir, Point pos, int capacity){
        super(dir, pos);
        this.cars = new LinkedList<>();
        this.capacity = capacity;
    }


    /**
     * Unloads the last car which entered the platform.
     * @return Car which was unloaded. May return null.
     */
    @Override
    public T unload() {//T represents the most specific static type
        return this.cars.poll();//First in first out
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
        if(o == null) return;//Or throw exception later

        if(this.isDisallowed(o)){
            throw new IllegalArgumentException("Cannot load a TransportTruck unto this platform.");
        }

        if(this.cars.size() >= this.capacity){
            throw new IllegalArgumentException("The workshop is full!");
        }

        this.cars.addLast(o);
    }

    @Override
    public boolean isDisallowed(Car t) {
        return false;
    }


    @Override
    public void addObserver(PositionObserver positionObserver) {
        this.observablePosition.addObserver(positionObserver);
    }

    @Override
    public void deleteObserver(PositionObserver positionObserver) {
        this.observablePosition.deleteObserver(positionObserver);
    }

    @Override
    public void notifyObservers(Point newPosition) {
        this.observablePosition.notifyObservers(newPosition);
    }


    @Override
    public void move(){
        super.move();
        this.observablePosition.notifyObservers(this.getPosition());
    }

}
