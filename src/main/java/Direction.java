package src.main.java;
/**
 * Represents the cardinal directions.
 */
public enum Direction {

    NORTH(0), SOUTH(2), WEST(3), EAST(1);

    private int value;

    private Direction(int value){
        this.value = value;
    }

    /**
     * Gets the direction to the right of the current direction.
     * @return Returns a direction
     */
    public Direction getRightDirection(){
        return getDirection(Math.abs(value + 5) % 4);
    }

    /**
     * Gets the direction corresponding to the value given
     * @return
     */
    public static Direction getDirection(int value){
        switch(value){
            case 0: return NORTH;
            case 1: return EAST;
            case 2: return SOUTH;
            case 3: return WEST;
            default: return NORTH;
        }
    }

    /**
     * Gets the direction to the left of the current direction.
     * @return Returns a Direction
     */
    public Direction getLeftDirection(){
        return getDirection(Math.abs(value + 3) % 4);
    }

}
