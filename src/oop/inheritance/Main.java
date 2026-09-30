package oop.inheritance;

public class Main {

    public static void main(String[] args) {

        Car car = new Car("Toyota", 2020, 4);
        Motorcycle moto = new Motorcycle("Harley", 2021, "ATV");

        System.out.println(car.describe());
        System.out.println(moto.describe() + "\n");

        System.out.println(car.honk());
        System.out.println(moto.honk() + "\n");

        car.accelerate(50);
        moto.accelerate(30);

        System.out.println(car);
        System.out.println(moto + "\n");

        System.out.println(car.openTrunk());
        System.out.println(moto.getType() + "\n");

    }
    
}
