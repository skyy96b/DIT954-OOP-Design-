
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Direction;
import src.main.java.TransportTruck;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

import src.main.java.*;

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
        scania.stopEngine();//Need to not be moving to be able to lower
        for(int i = 0; i < 80; i++){
            scania.raise();
        }
        assert(this.scania.getCurrentSpeed() == 0 && scania.isInRestingState());
    }

    @Test
    void lower() {
        scania.stopEngine();//Need to not be moving to be able to lower
        for(int i = 0; i < 80; i++){
            scania.lower();
        }
        assert(this.scania.getCurrentSpeed() == 0 && !scania.isInRestingState());
    }


    @Test
    void loadAndUnload() {
        /**
         * Both Scania and Volvo240 has position (0, 0)
         * Thus they should be close enough to be able to load the volvo
         */
        Volvo240 volvo = new Volvo240();
        scania.lower();//needs to be lowered to be enterable
        scania.load(volvo);
        scania.load(null);
        assert(volvo == scania.unload());
        assert(scania.unload() == null);
    }


    @Test
    void loadProximity() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.incrementSpeed(10);
        for(int i = 0; i < 1000; i++){
            volvo.move();
        }
        scania.lower();//needs to be lowered to be enterable
        try {
            scania.load(volvo);
            scania.load(null);
            fail("No exception thrown despite being far away from the loading platform.");
        } catch (Exception e){
            assert(true);
        }
    }
}