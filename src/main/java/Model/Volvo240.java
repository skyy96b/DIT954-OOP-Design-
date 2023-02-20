package src.main.java.Model;
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
    public double speedFactor(){
        return this.getEnginePower() * 0.01 * trimFactor;
    }

}
