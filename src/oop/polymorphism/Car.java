package oop.polymorphism;

public class Car extends Vehicle {
    
    public Car(String name) { 
        super(name); 
    }

    @Override 
    public String move() {
        return "Driving on road";
    }

    public String honk() { 
        return getName() + " is honking.";
    }
}
