package oop.abstraction;

public class Motorcycle extends Vehicle {

    public Motorcycle(String brand) { 
        super(brand);
    }

    @Override 
    public int getWheels() { 
        return 2; 
    }
    
}
