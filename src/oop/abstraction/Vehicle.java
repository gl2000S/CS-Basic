package oop.abstraction;

import java.util.List;

// ================= ABSTRACT CLASS =================
// Use when RELATED classes share STATE (fields) and CODE.
// "is-a": a Car IS A Vehicle.
public abstract class Vehicle {

    // Abstract classes CAN have fields (interfaces can't, except constants).
    private final String brand;
    private int speed; 

    // Abstract classes CAN have constructors. You can't call "new Vehicle"
    // but children call this with super(...)
    Vehicle(String brand) { 
        this.brand = brand; 
    }

    public String getBrand() { 
        return brand; 
    }

    // ABSTRACT METHOD: no body. 
    // Every concrete child MUST implement it. 
    public abstract int getWheels();

    // Concrete Method: Shared code, written once, inherited by all children. 
    public void accelerate(int amount) { 
        speed += amount; 
    }

    // Concrete method can CALL an abstract one, 
    // each child fills in the detail. 
    public String describe() { 
        return brand + " with " + getWheels() + " wheels going " + speed + "mph" ; 
    }
    
}
