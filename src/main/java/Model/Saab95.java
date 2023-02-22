package src.main.java.Model;
import java.awt.*;

/**
 * Represents a Saab95 with turbo.
 * 
 * ludvighygrell@gmail.com
 * sky.belin96@gmail.com
 */
public class Saab95 extends Car{

    private boolean turboOn;
    /**
     * Creates a Saab95
     */
    Saab95(){
        super(2, 125, Color.RED, "Saab95");
	    turboOn = false;
        stopEngine();
    }

    public Saab95(int x, int y){
        super(new Point(x, y), Direction.NORTH, 2, 125, Color.RED, "Saab95");
        turboOn = false;
        stopEngine();
    }

    /**
     * Turn on turbo
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Turn off turbo
     */
    public void setTurboOff(){
	    turboOn = false;
    }
    
     /**
     * {@inheritDoc}
      * * @throws IllegalArgumentException when incorrect range
     */
    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }


}
