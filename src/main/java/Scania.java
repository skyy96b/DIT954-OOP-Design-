import java.awt.*;


/**
 * a Scania Truck. With 2 doors & 200 engine power
 */
public class Scania extends Truck implements IPlatform {

    /**
     * Constructs a Scania Truck. With 2 doors & 200 engine power
     *
     * @param startPos Start position of the truck
     * @param dir Direction of the truck
     */
    public Scania(Point startPos, Direction dir){
        super(startPos, dir, Color.black, "ScaniaTruck");
        this.setPlatform(new TiltablePlatform());
    }

    /**
     * Puts the foot on the gas pedal.
     * @param amount Higher amount increases the overall speed. In range [0, 1]
     * @throws Exception
     */
    @Override
    public void gas(double amount) throws Exception {
        if(this.platform == null || this.isInRestingState()){ //If not tilted => can run truck
            super.gas(amount);
        }
    }


}
