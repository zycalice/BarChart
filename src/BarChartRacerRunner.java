import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class BarChartRacerRunner {
    public static void main(String[] args) {
        BarChartRacer bcr = new BarChartRacer();
        bcr.readDraw("./data files/cities.txt");
//        bcr.readDraw("./data files/baby.txt");
//        bcr.readDraw("./data files/movies.txt");
    }
}
