import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputCheckTest {

    UserInputCheck uic;

    @BeforeEach
    void setUp(){
        uic = new UserInputCheck();
    }

    @Test
    void testValidFileNameTrueTXT(){
        assertTrue(uic.inputIsFileName("file.txt","txt"));
    }

    @Test
    void testValidFileNameTrueCSV(){
        assertTrue(uic.inputIsFileName("file.csv","csv"));
    }

    @Test
    void testValidFileNameFalse(){
        assertFalse(uic.inputIsFileName("file","txt"));
    }
}