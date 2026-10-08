package oop.composition;

public class Main {
    public static void main(String[] args){

        // 1. COMPOSITION + DELEGATION 
        Car normalCar = new Car("Normal Car", new GasEngine(), new GPS());
        System.out.println(normalCar.start());
        System.out.println(normalCar.navigate("New York"));

        normalCar.setEngine(new ElectricEngine());
        System.out.println(normalCar.start());

        Engine weirdCar = new BadCar();
        System.out.println(weirdCar.start());
    }
    
}




