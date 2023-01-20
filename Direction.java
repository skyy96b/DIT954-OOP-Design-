
/**
 * Represents the cardinal directions.
 */
public enum Direction {

    NORTH(0), SOUTH(2), WEST(3), EAST(1);

    private int value;

    private Direction(int value){
        this.value = value;
    }

    public Direction getRightDirection(){
        return getDirection(value);
    }

    public static Direction getDirection(int value){
        switch(value){
            case 0: return EAST;
            case 1: return SOUTH;
            case 2: return WEST;
            case 3: return NORTH;
            default: return NORTH;
        }
    }

    public Direction getLeftDirection(){
        return getDirection(Math.abs(value - 3) % 4);
    }

}
