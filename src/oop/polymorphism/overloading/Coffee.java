package oop.polymorphism.overloading;


public class Coffee {

    // CONSTRUCTOR OVERLOADING : same idea applied to constructors

    private final String size;
    private final boolean milk; 

    // Version 1 = no arguments -> defaults
    public Coffee() { 
        this("medium", false); // this(...) calls ANOTHER constructor in this class.
    }

    // Version 2 = size only
    public Coffee(String size) { 
        this(size, false);
    }

    // Version 3 = full version.
    // Validation and assignment live in ONE place
    public Coffee(String size, boolean milk) { 
        this.size = size;
        this.milk = milk;
    }


    @Override 
    public String toString() {
        return size + ", " + (milk ? "with milk" : "no milk");
    }




    
}
