package src.main.java.Model;



import java.awt.*;

/**
 * a Transporter Truck. With 2 doors & 200 engine power
 */
public class TransportTruck extends Truck implements IPlatform, ITransporter<Car> {

    /**
     * Constructs a TransportTruck. With 2 doors & 200 engine power
     *
     * @param startPos Start position of the truck
     * @param dir      Direction of the truck
     */
    public TransportTruck(Point startPos, Direction dir) {
        super(startPos, dir, Color.black, "Transporter");
       this.setPlatform(new RampPlatform(this));
    }

    /**
     * Puts the foot on the gas pedal.
     *
     * @param amount Higher amount increases the overall speed. In range [0, 1]
     * @throws Exception
     */
    @Override
    public void gas(double amount) throws Exception {
        if (this.platform == null || this.getState()) { //If ramp is raised => can run truck (not required of lab specific.)
            super.gas(amount);
        }
    }

    /**
     * Gets the current state (raised or lowered ramp). Since a TransportTruck
     * always has a RampPlatform.
     * @return
     */
    @Override
    public Boolean getState() {
        return (Boolean) this.platform.getState();
    }



    /**
     * Unloads cars from existing loadable platform.
     * @return The car which last entered the loadable platform(if any exists)
     */
    @Override
    public Car unload() {
        if(this.platform != null && this.platform instanceof Loadable){
            return ((Loadable<Car>)  this.platform).unload();
        } else {
            return null;
        }

    }

    /**
     * Loads cars onto any existing loadable platform.
     * @param car Load this car unto any existing loadable platform.
     */
    @Override
    public void load(Car car) {
        if(this.platform != null && this.platform instanceof Loadable){
            ((Loadable<Car>)  this.platform).load(car);
        }
    }

    /**
     * Checks if an object is compatible with the loading platform.
     * @param car The object to check if it is disallowed.
     * @return True if the object is not allowed to be loaded on this platform.
     */
    @Override
    public boolean isDisallowed(Car car) {
        /*
           Since a truck in reality can possibly change loading platform.
           In reality we must dynamically check if the current loading platform
           is actually loadable before loading cars into it.
         */
        if(this.platform != null && this.platform instanceof Loadable){
            return ((Loadable) this.platform).isDisallowed(car);
        }
        return false;
    }
}