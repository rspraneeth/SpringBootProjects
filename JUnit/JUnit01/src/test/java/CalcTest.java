import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    void testDivide() {
        Calc c = new Calc();
        int act = c.divide(10, 5);
        assertEquals(2, act);
    }
}