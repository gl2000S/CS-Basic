package oop.abstraction;

// ================= INTERFACES =================
// Use when classes share a CAPABILITY, even if they're UNRELATED.
// "can-do": an ElectricCar CAN charge; a Phone CAN charge.
public interface Electric {
    
    // Fields in an interface are automatically public static final 
    // aka. constants
    int MAX_BATTERY = 100;

    // Methods are automatically public abstract.
    // No ABSTRACT needed. 
    public void charge(); 
    public int getBatteryLevel();

    // DEFAULT METHOD: has a body. Implementing classes get it for free. 
    public default String batteryStatus() { 
        return "Battery: " + getBatteryLevel() + "/" + MAX_BATTERY;
    }
}
