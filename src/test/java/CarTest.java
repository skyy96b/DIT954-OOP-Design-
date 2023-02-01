
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car = null;

    @BeforeEach
    void setUp() {
        car = new Volvo240();
    }

    @AfterEach
    void tearDown() {
        car = null;
    }

    @Test
    void getNrDoors() {
        assert(car.getNrDoors() == 4);
    }

    @Test
    void getEnginePower() {
        assert(car.getEnginePower() == 100);
    }

    @Test
    void getCurrentSpeed() {
        assert(car.getCurrentSpeed() == 0);
    }

    @Test
    void getColor() {
        assert(car.getColor() == Color.BLACK);
    }

    @Test
    void setColor() {
        car.setColor(Color.white);
        assert(car.getColor() != Color.BLACK);
    }

    @Test
    void startEngine() {
        car.startEngine();
        assert(car.getCurrentSpeed() > 0f);
    }

    @Test
    void stopEngine() {
        car.startEngine();
        car.stopEngine();
        assert(car.getCurrentSpeed() == 0);
    }

    @Test
    void gas() throws Exception {
        car.startEngine();
        double speedA = car.getCurrentSpeed();
        car.gas(1);
        double speedB = car.getCurrentSpeed();
        assert(speedB > speedA);
    }

    @Test
    void brake() throws Exception {
        car.startEngine();
        double speedA = car.getCurrentSpeed();
        car.brake(1);
        double speedB = car.getCurrentSpeed();
        assert(speedB < speedA);
    }

    @Test
    void move() throws Exception {
        Point a = car.getPosition();
        car.startEngine();
        car.gas(1);
        car.move();
        Point b = car.getPosition();
        assert(!a.equals(b));
    }

    @Test
    void turnLeft() {
        Direction a = car.getDirection();
        car.turnLeft();
        System.out.println(car.getDirection());
        assert(Direction.NORTH == a && Direction.WEST == car.getDirection());//Original dir is NORTH
    }

    @Test
    void turnRight() {
        Direction a = car.getDirection();
        car.turnRight();
        assert(Direction.NORTH == a && car.getDirection() == Direction.EAST);//Original dir is NORTH
    }
}