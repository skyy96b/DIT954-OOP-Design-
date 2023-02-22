package src.main.java.Model;

import java.awt.*;

/**
 * A Vehicle which can move, turn etc..
 */
public abstract class Vehicle implements Movable, PositionObserver{

    private Direction direction;
    private Point position; //Protected bcause needed in subclasses (.ie car)
    private double currentSpeed; //Protected because needed in subclasses

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
    public Point getPosition() {
        return new Point(this.position);//Mutate by copy
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

    protected void setCurrentSpeed(double speed){
        this.currentSpeed = speed;
    }
    protected void setPosition(Point position){
        this.position = position;
    }
    protected void setPosition(int x, int y){
        this.position = new Point(x,y);
    }




    /**
     * All cars can get position updates if they listen to a ObservablePosition/ITransporter
     * @param point
     */
    @Override
    public void onPositionUpdate(Point point) {
        this.setPosition(point);
    }

}
