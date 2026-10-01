package oop.abstraction;

public class Main {

    public static void main(String[] args) { 

        // Vehicle vehicle = new Vehicle() , does not compile

        Car car = new Car();
        car.go();
        car.stop();
        System.out.println(car.honk());

    }


}