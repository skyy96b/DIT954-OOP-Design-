


/*

 *
 * TODO: Think about whether a truck with no platform should be a general/abstract class.
 *  And then use composition for two different implementations of Tiltable.
 *
 */

import java.awt.*;

/**
 * a Transporter Truck. With 2 doors & 200 engine power
 */
public class TransportTruck extends Truck implements IPlatform {

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


}