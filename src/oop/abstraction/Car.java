package oop.abstraction;

public class Car extends Vehicle {
    
    @Override 
    public void go() { 
        System.out.println("The car is moving.");
    }

    @Override
    public void stop() {
        System.out.println("The car has stopped.");
    }

    @Override
    public String honk() {
        return "Beep beep!";
    }

}
