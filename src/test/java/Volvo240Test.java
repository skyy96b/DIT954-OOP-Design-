
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.main.java.Model.Car;
import src.main.java.Model.Volvo240;

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
        int amount = 1;
        car.startEngine();
        double value = Math.min(car.getCurrentSpeed() + car.speedFactor() * amount, car.getEnginePower());;
        System.out.println(car.getCurrentSpeed() + ":" + car.speedFactor() + ":" + car.getEnginePower() + ": " + value + " . " );
        car.incrementSpeed(amount);
        System.out.println(car.getCurrentSpeed());
        assert(value == car.getCurrentSpeed());
    }

    @Test
    void decrementSpeed() throws Exception {
        int amount = 1;
        double value =  Math.max(car.getCurrentSpeed() - car.speedFactor() * amount,0);
        car.decrementSpeed(amount);
        assert(value == car.getCurrentSpeed());
    }
}