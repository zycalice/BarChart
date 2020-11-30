
public class BarChartRacerRunner {
    public static void main(String[] args) {
        BarChartRacer bcr = new BarChartRacer();
        bcr.readDraw(bcr.getFileName());

        //you could also uncomment below to set a default file path
//        String path = "./data files/";
//        bcr.readDraw(path + bcr.getFileName());

    }
}
