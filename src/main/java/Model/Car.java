package src.main.java.Model;
import java.awt.*;


/**
 * The common parts of a movable car.
 */
public abstract class Car extends Vehicle implements Transportable<ITransporter> { //All cars transportable by all types of vehicles (like FerryBoats and trucks)

    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name

    
    /**
     * Initiates the Car object
     * @param doors Amount of doors
     * @param enginePower Power of the engine
     * @param color Colour of the car
     * @param modelName Model of the car
     * @param startPosition Cars starting point
     * @param dir The direction the car is facing at the start.
     */
    public Car(Point startPosition, Direction dir, int doors, double enginePower, Color color, String modelName){
        super(dir, startPosition);
        this.nrDoors = doors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
    }

    /**
     * Initiates the Car object
     * @param doors Amount of doors
     * @param enginePower Power of the engine
     * @param color Colour of the car
     * @param modelName Model of the car
     */
    public Car(int doors, double enginePower, Color color, String modelName){
        super(Direction.NORTH, new Point(0,0));
        this.nrDoors = doors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
    }
    
    /**
     * Gets the amount of doors.
     * @return Returns the value
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Gets the engine power.
     * @return Returns the value
     */
    public double getEnginePower(){
        return enginePower;
    }


    /**
     * Fetches the color.
     * @return Returns the value
     */
    public Color getColor(){
        return color;
    }

    /**
     * Sets the color.
     * @param clr The new colour of the car
     */
    public void setColor(Color clr){
	    color = clr;
    }

    /**
     * Starts the engine
     */
    public void startEngine(){
        setCurrentSpeed(0.1);
    }

    /**
     * Stops the engine
     */
    public void stopEngine(){
        setCurrentSpeed(0);
    }
    
    //Part of Open-Closed principle
    /**
     * Gets speedfactor.
     * @return Returns the speedfactor.
     */
    public abstract double speedFactor();

    /**
     * {@inheritDoc}
     * @throws IllegalArgumentException when incorrect range
     */

    public void incrementSpeed(double amount) throws IllegalArgumentException{
        double speed = Math.min(getCurrentSpeed() + speedFactor() * amount, this.getEnginePower());
        if(speed > this.getEnginePower() || speed < 0){
            throw new IllegalArgumentException("Speed < 0, or speed greater than engine power");
        }
        setCurrentSpeed(Math.min((getCurrentSpeed() + speedFactor() * amount), this.getEnginePower()));
    }

    /**
     * {@inheritDoc}
     * @throws IllegalArgumentException when incorrect range
     */
    public void decrementSpeed(double amount) throws IllegalArgumentException{
        double speed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        if(speed > this.getEnginePower() || speed < 0){
            throw new IllegalArgumentException();
        }
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }
    /**
     * Puts the foot on the gas
     * @param amount Higher amount increases the overall speed. In range [0, 1]
     * @throws IllegalArgumentException when incorrect range
     */
    public void gas(double amount) throws Exception {
        if( amount < 0 || amount > 1){
            throw new IllegalArgumentException("Accepts only range [0, 1]");
        } else {
            double speedA = this.getCurrentSpeed();
            incrementSpeed(amount);
            double speedB = this.getCurrentSpeed();
            //if(speedB < speedA) System.exit(0);
        }
    }

    /**
     * Puts the foot on the brakes
     * @param amount Higher amount decreases the overall speed. In range [0, 1]
     * @throws IllegalArgumentException when incorrect range
     */
    public void brake(double amount) throws Exception
    {
        if( amount < 0 || amount > 1) throw new IllegalArgumentException("Accepts only range [0, 1]");
        double speedA = this.getCurrentSpeed();
        decrementSpeed(amount);
        double speedB = this.getCurrentSpeed();
        if(speedB > speedA) System.exit(0);
    }

    //-----------------------


    /**
     * All cars can get position updates if they listen to a ObservablePosition/ITransporter
     * @param point
     */
    @Override
    public void onPositionUpdate(Point point) {
        this.setPosition(point);
    }
}
