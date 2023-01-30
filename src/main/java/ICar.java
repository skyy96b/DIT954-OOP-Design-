import java.awt.*;

/**
 * Interface for what a car needs.
 */
public interface ICar extends IVehicle{


    /**
     * Gets the amount of doors.
     * @return Returns the value
     */
    public int getNrDoors();

    /**
     * Gets the engine power.
     * @return Returns the value
     */
    public double getEnginePower();

    /**
     * Gets the current speed
     * @return Returns the value
     */
    public double getCurrentSpeed();

    /**
     * Fetches the color.
     * @return Returns the value
     */
    public Color getColor();

    /**
     * Sets the color.
     * @param clr The new colour of the car
     */
    public void setColor(Color clr);

    /**
     * Starts the engine
     */
    public void startEngine();

    /**
     * Stops the engine
     */
    public void stopEngine();

    //Part of Open-Closed principle
    /**
     * Gets speedfactor.
     * @return Returns the speedfactor.
     */
    double speedFactor();

    /**
     * {@inheritDoc}
     * @throws IllegalArgumentException when incorrect range
     */

    void incrementSpeed(double amount) throws IllegalArgumentException;

    /**
     * {@inheritDoc}
     * @throws IllegalArgumentException when incorrect range
     */
    void decrementSpeed(double amount) throws IllegalArgumentException;

    /**
     * Puts the foot on the gas
     * @param amount Higher amount increases the overall speed. In range [0, 1]
     * @throws IllegalArgumentException when incorrect range
     */
    public void gas(double amount) throws Exception;

    /**
     * Puts the foot on the brakes
     * @param amount Higher amount decreases the overall speed. In range [0, 1]
     * @throws IllegalArgumentException when incorrect range
     */
    public void brake(double amount) throws Exception;

    /**
     * Moves the car
     */
    public void move();

    /**
     * Turns left
     */
    public void turnLeft();

    /**
     * Turns right
     */
    public void turnRight();

    /**
     * Gets the current direction the car is facing.
     * @return Returns the current direction
     */
    public Direction getDirection();

    /**
     * Returns an immutable point of the current position.
     * @return Returns the current position.
     */
    public Point getPosition();


}
