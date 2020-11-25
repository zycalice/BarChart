import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BarTest {

    Bar b1;
    Bar b2;
    Bar b3;

    @BeforeEach
    void setUp(){
        b1 = new Bar("bar1",20,"a");
        b2 = new Bar("bar2",10,"b");
        b3 = new Bar("bar3",20,"c");

    }

    @Test
    void testConstructor1(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Bar b = new Bar(null, 20,"haha" );
        });
    }

    @Test
    void testConstructor2(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Bar b = new Bar("haha", -1,"haha" );
        });
    }

    @Test
    void testConstructor3(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Bar b = new Bar("haha", 1,null);
        });
    }

    @Test
    void getName() {
        assertEquals("bar1", b1.getName());
    }

    @Test
    void getValue() {
        assertEquals(20, b1.getValue());
    }

    @Test
    void getCategory() {
        assertEquals("a", b1.getCategory());
    }

    @Test
    void compareToGreater() {
        assertEquals(1, b1.compareTo(b2));
    }

    @Test
    void compareToLess() {
        assertEquals(-1, b2.compareTo(b1));
    }

    @Test
    void compareToEqual1() {
        assertEquals(0, b1.compareTo(b1));
    }

    @Test
    void compareToEqual2() {
        assertEquals(0, b1.compareTo(b3));
    }

    @Test
    void compareToEqualThrowException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            int result = b1.compareTo(null);
        });
    }

}