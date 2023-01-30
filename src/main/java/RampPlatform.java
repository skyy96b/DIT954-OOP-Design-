import javax.swing.text.Position;
import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

public class RampPlatform implements IPlatform<Boolean>, Loadable<Car>  {


    /**
     * Tells whether the loading platform is raised or lowered.
     * Two states.
     */
    private boolean raised = true;
    private Deque<Car> cars;
    private Truck carWithPlatform;

    /**
     * A RampPlatform that can be assigned to a car
     *
     * @param car A car which has this platform connected to it (needed to check distance when loading cars onto ramp)
     */
    public RampPlatform(Truck car){
        this.cars = new LinkedList();
        this.carWithPlatform = car;
    }



    /**
     * Raises the platform by 1 degree. If angle > 70 it is unchanged.
     */
    @Override
    public void raise() {
        this.raised = true;
    }

    /**
     * Lowers the platform by 1 degree. If angle <= 0 then it is set to 0.
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
     * @return Car which was unloaded. Having moved it a little bit away from the ramp.
     */
    @Override
    public Car unload() {
        if(this.isInRestingState()){// Ramp in resting state => unloading not allowed
            throw new IllegalArgumentException("The ramp cannot be unloaded as it is not lowered.");
        }

        Car car = this.cars.poll();//First in last out
        //Position of car must be that off the transporter when being unloaded
        car.setPosition(new Point(this.carWithPlatform.getPosition()));
        car.setTransporter(null); //Car no longer transported => no longer same position as transporter
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

        o.setTransporter(this.carWithPlatform);//Reflect same position for the car as the truck
        this.cars.add(o);
    }

    @Override
    public boolean isDisallowed(Car t) {
        if(t instanceof TransportTruck){//A ramp platform cannot load a TransportTruck
            return true;
        }
        return false;
    }
}
