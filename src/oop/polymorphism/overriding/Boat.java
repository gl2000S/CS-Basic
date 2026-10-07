package oop.polymorphism.overriding;

public class Boat extends Vehicle {

    // TRAP : looks like Override, but the parameter list is different 
    // () vs (int speed) is an OVERLOAD.
    // adding @Override is a compile error. 
    public String move(int speed) { 
        return "sails at " + speed + " knots";
    }
    
}
