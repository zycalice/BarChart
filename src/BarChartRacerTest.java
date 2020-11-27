import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BarChartRacerTest {

    BarChartRacer bcr;

    @BeforeEach
    void setBcr(){
        bcr = new BarChartRacer();
    }

    @Test
    void testSort(){
        Bar b1 = new Bar("bar1",20,"a");
        Bar b2 = new Bar("bar2",10,"b");
        Bar b3 = new Bar("bar3",15,"c");
        ArrayList<Bar> bars = new ArrayList<>();
        ArrayList<Bar> bars_sorted = new ArrayList<>();
        bars.add(b1);
        bars.add(b2);
        bars.add(b3);

        bars_sorted.add(b1);
        bars_sorted.add(b3);
        bars_sorted.add(b2);

        assertEquals(bars_sorted, bcr.sortBars(bars));
    }


}