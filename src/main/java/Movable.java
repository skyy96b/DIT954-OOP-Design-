

/**
 * Represents being movable in some directon.
 */
public interface Movable {

    /**
     * The the car in the current direction.
     */
    public void move();

    /**
     * Turn left in relation to the current direction of something.
     */
    public void turnLeft();

    /**
     * Turn right in relation to the current direction of something.
     */
    public void turnRight();
    
}
