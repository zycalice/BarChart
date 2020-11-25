public class Bar implements Comparable<Bar> {

    private String name;
    private int value;
    private String category;

    // Creates a new bar.
    public Bar(String name, int value, String category){
        if (name == null || value < 0 || category == null){
            throw new IllegalArgumentException ("Name and category cannot be NULL; value cannot be negative.");
        }

        this.name = name;
        this.value = value;
        this.category = category;
    }

    // Returns the name of this bar.
    public String getName(){
        return this.name;
    }

    // Returns the value of this bar.
    public int getValue(){
        return this.value;
    }

    // Returns the category of this bar.
    public String getCategory(){
        return this.category;
    }

    // Compare two bars by value.
    @Override
    public int compareTo(Bar that){
        if (this == that) return 0;
        return Integer.compare(this.value, that.value);
    }


}