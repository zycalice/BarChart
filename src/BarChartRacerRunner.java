import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class BarChartRacerRunner {
    public static void main(String[] args) {
        BarChartRacer bcr = new BarChartRacer();
        String dataPath = "./data files/";
        bcr.readDraw(dataPath + bcr.getFileName());
    }
}
