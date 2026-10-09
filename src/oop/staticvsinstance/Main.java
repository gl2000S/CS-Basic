package oop.staticvsinstance;


public class Main {
    public static void main(String[] args) {

        // 1. Static members work BEFORE any object exists.
        System.out.println(Car.getCarsBuilt());

        // 2. Each object has its OWN instance fields...
        Car a = new Car("Toyota");
        Car b = new Car("Honda");
        a.accelerate(70);
        b.accelerate(100);
        
        // ...but they SHARE the static field.
        System.out.println(a.describe());
        System.out.println(b.describe());

        // 3. Call static members on the CLASS NAME, not on an object.
        System.out.println(Car.getCarsBuilt());
        System.out.println(Car.MAX_SPEED);
        System.out.println(Car.isValidSpeed(150));

        // 4. Why helper methods in Main need "static":
        //    main is static, so it can only call other static methods directly.
        printCar(a);

    }

    public static void printCar(Car car) {
        System.out.println("Car: " + car.describe());
    }
    
}
