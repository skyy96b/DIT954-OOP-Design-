package src.test.java;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

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