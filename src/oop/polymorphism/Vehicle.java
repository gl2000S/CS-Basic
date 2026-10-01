package oop.polymorphism;

public abstract class Vehicle {

    private final String name; 

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() { 
        return name; 
    }

    public abstract String move(); 

    public String describe() { 
        return getName() + " is " + move();
    }
    

    
}
