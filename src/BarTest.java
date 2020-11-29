import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BarTest {

    Bar b1;
    Bar b2;
    Bar b3;

    //setup before each test
    @BeforeEach
    void setUp(){
        b1 = new Bar("bar1",20,"a");
        b2 = new Bar("bar2",10,"b");
        b3 = new Bar("bar3",20,"c");

    }

    //test when name is null
    @Test
    void testConstructorIllegalName(){
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Bar b = new Bar(null, 20,"hahaha" );
        });
        assertEquals("name is null",e.getMessage());
    }

    //test when value is negative
    @Test
    void testConstructorIllegalValueNegative(){
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Bar b = new Bar("haha", -1,"hahaha" );
        });
        assertEquals("value must be non-negative", e.getMessage());
    }

    //test when category is null
    @Test
    void testConstructorIllegalCategory(){
        Exception e = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Bar b = new Bar("haha", 1,null);
        });
        assertEquals("category is null", e.getMessage());
    }

    //test when value is zero
    @Test
    void testConstructorValidValue0(){
        Bar b = new Bar("haha", 0,"hahaha" );
        assertEquals("haha", b.getName());
        assertEquals(0, b.getValue());
        assertEquals("hahaha", b.getCategory());
    }

    //test when input is simply valid
    @Test
    void testConstructorValid(){
        Bar b = new Bar("haha", 100,"hahaha" );
        assertEquals("haha", b.getName());
        assertEquals(100, b.getValue());
        assertEquals("hahaha", b.getCategory());
    }


    //test name getter
    @Test
    void getName() {
        assertEquals("bar1", b1.getName());
    }

    //test value getter
    @Test
    void getValue() {
        assertEquals(20, b1.getValue());
    }

    //test category getter
    @Test
    void getCategory() {
        assertEquals("a", b1.getCategory());
    }

    //test compareTo when this bar's value is greater than other bar; return -1 bc reverse sort
    @Test
    void compareToGreater() {
        assertEquals(-1, b1.compareTo(b2));
    }

    //test compareTo when this bar's value is less than other bar; return 1 bc reverse sort
    @Test
    void compareToLess() { assertEquals(1, b2.compareTo(b1)); }

    //test compareTo when this bar's value is equal to itself
    @Test
    void compareToEqual1() {
        assertEquals(0, b1.compareTo(b1));
    }

    //test compareTo when this bar's value is equal to that bar
    @Test
    void compareToEqual2() {
        assertEquals(0, b1.compareTo(b3));
    }

    //test compareTo when there is a null pointer exception
    @Test
    void compareToEqualThrowException() {
        Exception e = Assertions.assertThrows(NullPointerException.class, () -> {
            int result = b1.compareTo(null);
        });
        assertEquals("Input is null; should be a Bar",e.getMessage());
    }

    //test toString, which is not really needed for this assignment
    @Test
    void testToString(){
        assertEquals("bar1_20", b1.toString());
    }

}