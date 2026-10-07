package oop.polymorphism.overriding;

public class Car extends Vehicle {

    // Override same name, same parameter, same return type
    @Override 
    public String move() { 
        return "drives on the road";
    }

    // Override that EXTENDS the parent : super.startEngine() runs 
    // parent version, the Car adds to it. 
    @Override
    public String startEngine() {
        return super.startEngine() + " with a key";
    }

    @Override
    public String toString() {
        return "a car";
    }

}
