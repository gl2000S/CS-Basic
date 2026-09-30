package oop.inheritance;

public class Car extends Vehicle {

    private final int doors;

    public Car(String brand, int year, int doors) {
        super(brand, year);
        this.doors = doors;
    }

    public int getDoors() { 
        if (doors < 1) { 
            throw new IllegalArgumentException("Car must have at least one door");
        }
        return doors;
    }

    @Override
    public String honk() {
        return "Honk Honk!";
    }

    public String openTrunk() {
        return "Trunk is open!";
    }

}
