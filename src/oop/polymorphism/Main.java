package oop.polymorphism;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Vehicle v1 = new Car("Toyota"); 
        Vehicle v2 = new Boat("Sailboat");

        System.out.println(v1.move());
        System.out.println(v2.move());

        List<Vehicle> fleet = List.of (
            new Car("Honda"), 
            new Boat("Yacht")
        );
        
        for (Vehicle v : fleet) { 
            System.out.println(v.describe());
        }
    }

}
