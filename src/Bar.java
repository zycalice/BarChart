public class Bar implements Comparable<Bar> {

    private String name;
    private int value;
    private String category;

    // Creates a new bar.
    public Bar(String name, int value, String category){
        // Throw error when the below condition happens
        if (name == null) throw new IllegalArgumentException("name is null");
        if (category == null) throw new IllegalArgumentException("category is null");
        if (value <= 0) throw new IllegalArgumentException("value must be positive");

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
        if (that == null){
            throw new NullPointerException("Input is null.");
        }
        if (this == that) return 0;
        //reverse sort
        return -Integer.compare(this.value, that.value);
    }

    // For purpose to unit test the reverse sort in BarCharRacer
    @Override
    public String toString() {
        return  this.name + "_" + this.value;
    }


}