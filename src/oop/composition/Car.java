package oop.composition;

// ================= COMPOSITION: Car HAS-A Engine, HAS-A GPS =================
public class Car { 
    private final String name; 
    private Engine engine;          // a FIELD holding another object = composition.
    private final GPS gps; 

    public Car(String name, Engine engine, GPS gps) { 
        this.name = name; 
        this.engine = engine; 
        this.gps = gps; 
    }

    // DELEGATION: Car does not know HOW to start
    // hands job to its engine. 
    public String start() { 
        return name + " is starting: " + engine.start();
    }

    public String navigate(String destination) {
        return name + " is navigating: " + gps.route(destination);
    }

    public void setEngine(Engine engine) { 
        this.engine = engine; 
    }
}
