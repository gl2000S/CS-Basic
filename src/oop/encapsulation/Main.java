package oop.encapsulation;

//Class declaration. 
public class Main {

    //Main method, entry point of the program. 
    public static void main (String[] args) { 

        // Creating Objects of the Car class.
        Car car1 = new Car("Toyota", 2020, "Red");
        Car car2 = new Car("Honda", 2021, "Blue");
        
        System.out.println(car1.getModel() + " " + car1.getYear() + " " + car1.getColor());
        System.out.println(car2.getModel() + " " + car2.getYear() + " " + car2.getColor());

        car1.setColor("Green");
        car1.setYear(2022);

        car2.setModel("Ford");
        car2.setColor("Black");

        System.out.println(car1.getModel() + " " + car1.getYear() + " " + car1.getColor());
        System.out.println(car2.getModel() + " " + car2.getYear() + " " + car2.getColor());

    }
    
}
