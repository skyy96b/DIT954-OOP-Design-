import java.awt.*;

/**
 * Represents a Volvo240 which is trimmable.
 */
public class Volvo240 extends Car{

    /**
     * Trim factor of the volvo
     */
    public final static double trimFactor = 1.25;
    
    /**
     * Creates the Volvo car
     */
    public Volvo240(){
        super(4, 100, Color.black, "Volvo240");
        stopEngine();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    double speedFactor(){
        return this.getEnginePower() * 0.01 * trimFactor;
    }

     /**
     * {@inheritDoc}
     */
    @Override
    void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, this.getEnginePower());
    }

     /**
     * {@inheritDoc}
     */
    @Override
    void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

}
