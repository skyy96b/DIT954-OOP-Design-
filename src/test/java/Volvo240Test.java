import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {


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
    void speedFactor() {
        assert(100 * 0.01D * Volvo240.trimFactor == car.speedFactor());
    }

    @Test
    void incrementSpeed() throws Exception {
        int amount = 10;
        double value = Math.min(car.getCurrentSpeed() + car.speedFactor() * amount, car.getEnginePower());;
        car.incrementSpeed(amount);
        assert(value == car.getCurrentSpeed());
    }

    @Test
    void decrementSpeed() throws Exception {
        int amount = 10;
        double value =  Math.max(car.getCurrentSpeed() - car.speedFactor() * amount,0);
        car.decrementSpeed(amount);
        assert(value == car.getCurrentSpeed());
    }
}