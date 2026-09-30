package oop.inheritance;

public class Vehicle {

    private final String brand; 
    private final int year;

    protected int speed;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
        this.speed = 0;
    }

    public String getBrand() { 
        if (brand == null || brand.isEmpty()) { 
            throw new IllegalArgumentException("Brand cannot be null or empty");
        }
        return brand; 
    }

    public int getYear() { 
        if (year < 1900) { 
            throw new IllegalArgumentException("Year cannot be less than 1900");
        }
        return year; 
    }

    public void accelerate(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Acceleration amount cannot be negative");
        }
        speed += amount;
    }

    public String honk() {
        return "Beep beep!";
    }

    public String describe() { 
        return year + " " + brand;
    }

    @Override
    public String toString() {
        return describe() + " going " + speed + " km/h";
    }

}
