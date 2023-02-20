
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Model.Direction;
import src.main.java.Model.Scania;

import java.awt.*;

class ScaniaTest {

    private Scania scania;

    @BeforeEach
    void setUp() {
        scania = new Scania(new Point(0, 0), Direction.NORTH);
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