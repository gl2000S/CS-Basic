package oop.abstraction;

// NOT a Vehicle at all.
// it shares the Electric interface
public class Phone implements Electric {

    private int battery = 50;

    @Override 
    public int getBatteryLevel() { 
        return battery; 
    }

    @Override
    public void charge() {
        battery = MAX_BATTERY;
    }

}
