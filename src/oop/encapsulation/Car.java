package oop.encapsulation;

// Class declaration
public class Car {

    // A Field is a variable (also called instance variable or attribute). 
    private String model; 
    private int year; 
    private String color; 

    // Constructor, runs when object is created. 
    // Parameters: model, year, color
    // Arguments: "Toyota", 2020, "Red"
    public Car(String model, int year, String color) { 
        this.model = model; 
        this.year = year;
        this.color = color;
    }

    // ---------------- GETTERS (ACCESSORS) ----------------

    public String getModel() { 
        return model; 
    }

    public int getYear() { 
        if (year < 1900) { 
            throw new IllegalArgumentException("Year cannot be less than 1900");
        }
        return year;
    }

    public String getColor() {
        return color;
    }

    // ---------------- SETTERS (MUTATORS) ----------------

    public void setModel(String model) { 
        this.model = model; 
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColor(String color) { 
        this.color = color; 
    }
}

