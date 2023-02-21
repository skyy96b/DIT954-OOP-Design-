
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Model.CarFactory;
import src.main.java.Model.Direction;
import src.main.java.Model.Scania;
import src.main.java.Model.Truck;

import java.awt.*;

class ScaniaTest {

    private Truck scania;

    @BeforeEach
    void setUp() {
        scania = CarFactory.createScania(new Point(0, 0), Direction.NORTH);
    }

    @AfterEach
    void tearDown() {
        scania = null;
    }

    @Test
    void raise() {
        for(int i = 0; i < 80; i++){
            scania.raise();
        }
        assert(!scania.isInRestingState());
    }

    @Test
    void lower() {
        for(int i = 0; i < 80; i++){
            scania.lower();
        }
        assert(scania.isInRestingState());
    }
}