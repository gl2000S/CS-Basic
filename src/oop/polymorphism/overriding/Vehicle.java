package oop.polymorphism.overriding;

public class Vehicle {

    public String move() { 
        return "moves somehow";
    }

    public String startEngine() { 
        return "Engine started";
    }

    // final = children can't override. 
    public final String getType() { 
        return "Vehicle";
    }

    // Override Object's toString() method
    @Override 
    public String toString() {
        return "a vehicle";
    }
    
}
