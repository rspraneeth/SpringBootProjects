import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    @Test
    void reverseString() {
        assertEquals("avaj", new ReverseString().reverseString("java"), "String reverse function is not working");
        assertNotEquals("qqq", new ReverseString().reverseString("kohli"));
        assertTrue("avaj".equals(new ReverseString().reverseString("java")));
        assertFalse("alalala".length()<5);
    }

    @Test
    void reverseString_Supplier() {
        assertEquals("avaj", new ReverseString().reverseString("java"), ()-> "String reverse function is not working");
    }


}