package oop.abstraction;

// Extends ONE class AND implements MULTIPLE interfaces. 
public class ElectricCar extends Vehicle implements Electric, SelfDriving {

    private int battery = 20; 

    public ElectricCar(String brand) {
        super(brand);
    }

    // Abstract class Vehicle 
    @Override 
    public int getWheels() {
        return 4; 
    }

    // Interface Electric
    @Override 
    public void charge() { 
        battery = MAX_BATTERY; 
    }

    // Interface Electric
    @Override 
    public int getBatteryLevel() { 
        return battery; 
    }

    // Interface SelfDriving
    @Override 
    public String selfDrive(String destination) {
        return getBrand() + " driving itself to " + destination; 
    }
    
}
