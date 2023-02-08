

import javax.swing.text.Position;
import java.awt.*;

/**
 * A Vehicle which can move, turn etc..
 */
public abstract class Vehicle implements Movable{

    private Direction direction;
    protected Point position; //Protected bcause needed in subclasses (.ie car)
    protected double currentSpeed; //Protected because needed in subclasses

    /**
     *
     * @param dir Starting direction of Vehicle
     * @param pos Starting position of vehicle.
     */
    public Vehicle(Direction dir, Point pos){
        this.direction = dir;
        this.position = pos;
    }

    /**
     * Get the current position
     * @return
     */
    public Point getPosition(){
        return this.position;
    }

    /**
     * Gets the current speed
     * @return Returns the value
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Moves the car in the current {@link #direction} and using the current speed.
     */
    public void move(){
        switch(direction){
            case NORTH: this.position.y += currentSpeed; break;
            case EAST: this.position.x += currentSpeed; break;
            case WEST: this.position.x -= currentSpeed; break;
            case SOUTH: this.position.y -= currentSpeed; break;
        }
    }

    /**
     * Turns left in relation to current {@link #direction}
     */
    public void turnLeft(){
        this.direction = this.direction.getLeftDirection();
    }

    /**
     * Turns right in relation to current {@link #direction}
     */
    public void turnRight(){
        this.direction = this.direction.getRightDirection();
    }

    /**
     * Gets the current direction the car is facing.
     * @return Returns the current direction
     */
    public Direction getDirection(){
        return this.direction;
    }


}
