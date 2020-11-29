import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BarChartRacer {

    private int numBarsToShow;
    private String fileName;
    UserInputCheck ui = new UserInputCheck();

    /**
     * constructor, set numBarsToShow to a user input
     */
    public BarChartRacer(){
        //ask the user for the filename
        System.out.println("Please enter the full data file path including .txt at the end.");
        this.fileName = ui.validTXTFileName();

        //ask the user for the number of bars they want to see
        System.out.println("Please enter the number of bars you want to see.");
        this.numBarsToShow = ui.validInteger(0, 1000000);
    }


    /**
     * getter
     * @return number of bars to show
     */
    public int getNumBarsToShow() {
        return numBarsToShow;
    }


    /**
     * getter
     * @return file name to graph
     */
    public String getFileName() {
        return fileName;
    }


    /**
     * reverse sorted bars (descending order)
     * separated this for unit testing purposes, made it public for this purpose as well
     * @param bars an array list of bars
     * @return a sorted array list of bars in the reverse order
     */
    public ArrayList<Bar> sortBars(ArrayList<Bar> bars){
        bars.sort(null);
        return bars;
    }


    /**
     * sort the bars and add the bars
     * @param bc the bar chart to add to
     * @param bars an array list of bars
     * @param numBarsToAdd number of bars to add = number of bars to show
     */
    private void sortAddBars (BarChart bc, ArrayList<Bar> bars, int numBarsToAdd){
        bars = sortBars(bars);
        for (int i=0; i<numBarsToAdd; i++){
            bc.add(bars.get(i).getName(), bars.get(i).getValue(), bars.get(i).getCategory());
        }
    }


    /**
     * read and then draw
     * @param filename the file to draw
     */
    public void readDraw(String filename){
        File f = new File (filename);
        Scanner scan;
        String line;
        String[] entries;
        Bar bar;

        try{
            scan = new Scanner(f);
            int numBars;

            //set up graph
            String title = scan.nextLine();
            String xAxis = scan.nextLine();
            String source = scan.nextLine();
            BarChart bc = new BarChart(title, xAxis, source);
            StdDraw.setCanvasSize(1000, 700);

            while (scan.hasNextLine()){
                //find the numbers that specified the number of bars for each year
                line = scan.nextLine();
                entries = line.split(",");

                //if the entry size is not 1, and if the length of the line is not blank
                if (entries.length==1 && line.length()!=0) {

                    //get the number of bars needed to read in
                    numBars = Integer.parseInt(line);

                    //read in the number of required bars; if less than required, read in all
                    ArrayList<Bar> bars = new ArrayList<>();
                    for (int i = 0; i < numBars; i++) {
                        line = scan.nextLine();
                        entries = line.split(",");
                        bc.setCaption(entries[0]);
                        //create the bar and add to the array list of bars
                        bar = new Bar(entries[1], Integer.parseInt(entries[3]), entries[4]);
                        bars.add(bar);
                    }

                    //add to sort add bars and draw
                    sortAddBars(bc, bars, numBarsToShow);

                    //draw using StdDraw
                    StdDraw.enableDoubleBuffering();
                    bc.draw();
                    StdDraw.show();
                    StdDraw.pause(90);

                    //reset and clear
                    bc.reset();
                    StdDraw.clear();

                }
            }
        }catch (FileNotFoundException e){
            System.out.println("bad file name; current path is" + f.getAbsolutePath());
            e.printStackTrace();

        }
    }

}
