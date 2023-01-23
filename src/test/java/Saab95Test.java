import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {



    private Saab95 car = null;

    @BeforeEach
    void setUp() {
        car = new Saab95();
    }

    @AfterEach
    void tearDown() {
        car = null;
    }

    @Test
    void speedFactor() {
        car.setTurboOn();
        double turbo = 1.3;
        assert(car.getEnginePower() * 0.01 * turbo == car.speedFactor());
    }

    @Test
    void incrementSpeed() {
        int amount = 1;
        double value = Math.min(car.getCurrentSpeed() + car.speedFactor() * amount, car.getEnginePower());
        car.incrementSpeed(amount);
        assert(value == car.getCurrentSpeed());
    }

    @Test
    void decrementSpeed() {
        int amount = 1;
        double value =  Math.max(car.getCurrentSpeed() - car.speedFactor() * amount, 0);
        car.decrementSpeed(amount);
        assert(value == car.getCurrentSpeed());
    }

    @Test
    void setTurboBoth() {
        car.setTurboOff();
        double speedFactorTurboOff = car.speedFactor();

        car.setTurboOn();
        double speedFactorTurboOn = car.speedFactor();

        assert(speedFactorTurboOff < speedFactorTurboOn);
    }

}