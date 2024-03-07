import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    @Test
    void reverseString() {

        assertEquals("avaj", new ReverseString().reverseString("java"));
    }
}