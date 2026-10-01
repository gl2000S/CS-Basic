package oop.polymorphism;

public class Boat extends Vehicle {

    public Boat(String name) { 
        super(name); 
    }

    @Override 
    public String move() { 
        return "Sailing on water";
    }

    public String dropAnchor() { 
        return getName() + " is dropping anchor.";
    }
    
}
