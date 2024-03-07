import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    ReverseString r;

    @BeforeEach
    void init(){
        r=new ReverseString();
        System.out.println("before each test");
    }

    @BeforeAll
    static void initAll(){
        System.out.println("before all tests");
    }

    @Test
    @DisplayName("test1")
    void reverseString() {
        assertEquals("avaj", r.reverseString("java"), "String reverse function is not working");
        assertNotEquals("qqq", r.reverseString("kohli"));
        assertTrue("avaj".equals(r.reverseString("java")));
        assertFalse("alalala".length()<5);

    }

    @Test
//    @Disabled
//    @EnabledOnOs(OS.LINUX)
//    @EnabledOnJre(JRE.JAVA_17)
//    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11)
    void reverseString_Supplier() {
        assertEquals("avaj", r.reverseString("java"), ()-> "String reverse function is not working");
    }

    @RepeatedTest(3)
    void testArrays(){
        int[] act = {1, 2, 3};
        int[] exp = {1, 2, 3};
        assertArrayEquals(exp, act);
        assertTimeout(Duration.ofMillis(3), ()->{for (int i = 0; i < 1000000; i++){}});
    }

    @AfterEach
    void destroy(){
        System.out.println("cleanup after each test");
    }

    @AfterAll
    static void destroyAll(){
        System.out.println("cleanup once after all tests");
    }
}