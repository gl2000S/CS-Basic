package oop.abstraction;

import java.util.List;

public class Main {

    public static void main(String[] args) { 

        // Vehicle vehicle = new Vehicle() , does not compile

        // 1. Abstract class: shared code (accelerate, describe)
        // child-specific details (getWheels)
        List<Vehicle> vehicles = List.of(
            new Car("Toyota"), 
            new Motorcycle("Yamaha"),
            new ElectricCar("Tesla")
        );
        for (Vehicle v : vehicles) { 
            v.accelerate(30);
            System.out.println(v.describe());
        }

        // 2. INTERFACE: unrelated classes, same capabilities 
        // ElectricCar and Phone are unrelated, yet both fit in this List. 
        List<Electric> devices = List.of(new ElectricCar("Rivian"), new Phone());
        for (Electric e : devices) {
            System.out.println(e.batteryStatus());
            e.charge();
            System.out.println(e.batteryStatus());
        }

        // 3. MULTIPLE INTERFACES: one class, several capabilities.
        ElectricCar tesla = new ElectricCar("Tesla");
        System.out.println(tesla.selfDrive("airport"));

        //4. INTERFACE CONSTANT: accessed through the interface name.
        System.out.println(Electric.MAX_BATTERY);


        /** 
         * // Compile error: Interface cannot be instantiated
         * Electric e = new Electric();  
         * Electric phone = new Phone();
         * 
         * // Compile error: Electric has no selfDrive.
         * phone.selfDrive("home");
         */

    }


}