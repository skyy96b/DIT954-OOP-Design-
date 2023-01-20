
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
        return getDirection(value);
    }

    /**
     * Gets the direction corresponding to the value given
     * @return
     */
    public static Direction getDirection(int value){
        switch(value){
            case 0: return EAST;
            case 1: return SOUTH;
            case 2: return WEST;
            case 3: return NORTH;
            default: return NORTH;
        }
    }

    /**
     * Gets the direction to the left of the current direction.
     * @return Returns a Direction
     */
    public Direction getLeftDirection(){
        return getDirection(Math.abs(value - 3) % 4);
    }

}
