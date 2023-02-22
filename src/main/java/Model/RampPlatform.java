package src.main.java.Model;
import java.util.Deque;
import java.util.LinkedList;


public class RampPlatform implements IPlatform<Boolean>, Loadable<Car> {


    /**
     * Tells whether the loading platform is raised or lowered.
     * Two states.
     */
    private boolean raised = true;
    private Deque<Car> cars;
    private ITransporter carWithPlatform;

    private static final int maxCars = 8;

    /**
     * A RampPlatform that can be assigned to a car
     *
     * @param car A car which has this platform connected to it (needed to check distance when loading cars onto ramp)
     */
    public RampPlatform(ITransporter car){
        this.cars = new LinkedList();
        this.carWithPlatform = car;
    }



    /**
     * Raises the platformd.
     */
    @Override
    public void raise() {
        this.raised = true;
    }

    /**
     * Lowers the platform
     */
    @Override
    public void lower() {
        this.raised = false;

    }

    /**
     * Gets the state of the loading platform.
     * @return Returns true if raised & cannot enter the platform.
     */
    @Override
    public Boolean getState() {
        return this.raised;
    }

    /**
     *
     * @return Returns TRUE when the Ramp is up and the truck can drive.
     */
    @Override
    public boolean isInRestingState() {
        return this.raised;
    }

    /**
     * Gets the state of the loading platform.
     * @return Returns true if raised & cannot enter the platform.
     */
    public boolean isRaised(){
        return this.getState();
    }

    /**
     * Unloads the last car which entered the platform.
     *
     * @throws IllegalArgumentException Throws IllegalArgExc. when the ramp is not lowered.
     * @return Car which was unloaded. Having moved it a little bit away from the ramp. May return null
     */
    @Override
    public Car unload() {
        if(this.isInRestingState()){// Ramp in resting state => unloading not allowed
            throw new IllegalArgumentException("The ramp cannot be unloaded as it is not lowered.");
        }

        Car car = this.cars.poll();//First in last out
        if(car == null) return null;

        //car.setTransporter(null); //Car no longer transported => no longer same position as transporter
        carWithPlatform.deleteObserver(car);

        car.move(); //Move the car a little after unloading

        return car;
    }

    /**
     *
     * Load something unto the ramp platform.
     *
     * @param o The object to be loaded
     * @throws IllegalArgumentException Throws IllegalArgExc. when a certain type isn't allowed to be loaded. Or
     * when the ramp is not lowered. Or the car being loaded is too far away from the ramp.
     */
    @Override
    public void load(Car o) throws IllegalArgumentException{
        if(o == null) return;

        if(this.cars.size() >= maxCars){
            throw new IllegalArgumentException("Max allowed 8 cars.");
        }

        if(this.isDisallowed(o)){
            throw new IllegalArgumentException("Cannot load a TransportTruck unto this platform.");
        }
        if(this.isInRestingState()){// Ramp in resting state => loading not allowed
            throw new IllegalArgumentException("The ramp cannot be loaded as it is not lowered.");
        }
        double distance = o.getPosition().distance(this.carWithPlatform.getPosition());
        if(distance >5){//Can not load unless distance is less than 5 (car being loaded must be near)
            throw new IllegalArgumentException("The car is too far away o be loaded");
        }

        //o.setTransporter(this.carWithPlatform);//Reflect same position for the car as the truck
        this.carWithPlatform.addObserver(o);

        this.cars.push(o);
    }

    @Override
    public boolean isDisallowed(Car t) {
        /*
         We assume that if a car is not a Truck then it is not too big to be
         entered into the loading platform. (Which disallows TransportTrucks as required)
         */
        if(t instanceof Truck){//A ramp platform cannot load too big vehicles/trucks
            return true;
        }
        return false;
    }
}
