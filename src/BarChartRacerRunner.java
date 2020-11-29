import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class BarChartRacerRunner {
    public static void main(String[] args) {
        BarChartRacer bcr = new BarChartRacer();
        bcr.readDraw(bcr.getFileName());
    }
}
