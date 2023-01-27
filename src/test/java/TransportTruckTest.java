import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TransportTruckTest {

    private TransportTruck scania;

    @BeforeEach
    void setUp() {
        scania = new TransportTruck(new Point(0, 0), Direction.NORTH);
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
        assert(this.scania.getCurrentSpeed() == 0 && scania.getState());
    }

    @Test
    void lower() {
        for(int i = 0; i < 80; i++){
            scania.lower();
        }
        assert(this.scania.getCurrentSpeed() == 0 && !scania.getState());
    }
}