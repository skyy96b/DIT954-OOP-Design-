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
      * @throws IllegalArgumentException when incorrect range
     */
    @Override
    void incrementSpeed(double amount) throws IllegalArgumentException{
        double speed = Math.min(getCurrentSpeed() + speedFactor() * amount, this.getEnginePower());
        if(speed > this.getEnginePower() || speed < 0){
            throw new IllegalArgumentException();
        }
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, this.getEnginePower());
    }

     /**
     * {@inheritDoc}
      * @throws IllegalArgumentException when incorrect range
     */
    @Override
    void decrementSpeed(double amount) throws IllegalArgumentException{
        double speed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        if(speed > this.getEnginePower() || speed < 0){
            throw new IllegalArgumentException();
        }
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

}
