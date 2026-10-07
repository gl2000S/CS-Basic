package oop.abstraction;

public class Car extends Vehicle {

    public Car(String brand) { 
        super(brand); 
    }

    @Override 
    public int getWheels() { 
        return 4; 
    }

}
