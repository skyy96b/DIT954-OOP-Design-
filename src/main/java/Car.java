package src.main.java;
import javax.swing.text.Position;
import java.awt.*;

/**
 * The common parts of a movable car.
 */
public abstract class Car extends Vehicle{

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private String modelName; // The car model name

    /**
     * If car is being transported by a TransportTruck
     */
    private Truck transporter;
    
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
     * Reflects the position of the transporting truck.
     * @param truck Truck transporting this car. If the value is null then the car's position
     *              is set to that of the truck which it is unloaded from.
     */
    public void setTransporter(Truck truck){
        Truck oldTruck = this.transporter;
        this.transporter = truck;
        if(this.transporter == null && oldTruck != null){
            //No longer transported => update position of car to truck
            this.position = oldTruck.getPosition();
        }
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
     * Gets the current speed
     * @return Returns the value
     */
    public double getCurrentSpeed(){
        return currentSpeed;
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
	    currentSpeed = 0.1;
    }

    /**
     * Stops the engine
     */
    public void stopEngine(){
	    currentSpeed = 0;
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
            throw new IllegalArgumentException();
        }
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, this.getEnginePower());
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
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    /**
     * Puts the foot on the gas
     * @param amount Higher amount increases the overall speed. In range [0, 1]
     * @throws IllegalArgumentException when incorrect range
     */
    public void gas(double amount) throws Exception {
        if( amount < 0 || amount > 1) throw new IllegalArgumentException("Accepts only range [0, 1]");
        double speedA = this.getCurrentSpeed();
        incrementSpeed(amount);
        double speedB = this.getCurrentSpeed();
        if(speedB < speedA) System.exit(0);
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

    /**
     * Returns an immutable point of the current position.
     * @return Returns the current position.
     */
    public Point getPosition() {
        if (this.transporter == null) {
            return new Point(this.position);
        }
        return new Point(this.transporter.getPosition());//If beings transported keeps same position as transporter
    }

    //-----------------------

    
}
