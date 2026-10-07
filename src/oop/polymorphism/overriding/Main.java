package oop.polymorphism.overriding;

import java.util.List;

public class Main {
    public static void main(String[] args) { 
        Vehicle car = new Car();
        Vehicle boat = new Boat();

        //1. Real Override: Object type is Car, Car's move() runs.
        System.out.println(car.move());

        // 2. TRAP, boat never override move(), Vehicle's move() runs.
        System.out.println(boat.move());

        // 3. Overload exists, but only through a Boat reference.
        Boat myBoat = new Boat();
        System.out.println(myBoat.move(30));

        //4. super.method(): parent's logic + child's addition
        System.out.println(car.startEngine());
        
        // 5. Overriding toString() : println calls it automatically.
        System.out.println(car);

        // 6. One loop, for each objetc runs ITS OWN move()
        List<Vehicle> fleet = List.of(new Vehicle(), new Car(), new Boat());

        for (Vehicle v : fleet) { 
            System.out.println(v.move());
        }

    }
    
}
