package oop.staticvsinstance;

public class Car { 

    // STATIC CONSTANT: one shared, unchangeable value for the whole class 
    public static final int MAX_SPEED = 200;

    //STATIC FIELD: ONE copy shared by ALL Car objetcs. 
    private static int carsBuilt = 0; 

    //INSTANCE FIELDS: EACH Car object gets its own copy. 
    private final String name; 
    private final int serialNum; 
    private int speed; 

    public Car(String name) { 
        this.name = name;
        carsBuilt++;                        // update the ONE shared counter
        this.serialNum = carsBuilt;         // each car stores its own number
    }

    // INSTANCE METHOD: runs ON a specific object; can use instance AND static members 
    public void accelerate(int amount) { 
        speed = Math.min(speed + amount, MAX_SPEED);    //Math.min is a STATIC method
    }

    public String describe() {
        return name + " #" + serialNum + " going " + speed + " mph (" + carsBuilt + " total)";
    }

    // STATIC METHOD: belongs to the CLASS: no object needed
    public static int getCarsBuilt() {
        return carsBuilt;
    }

//STATIC UTILITY METHOD: needs no object data at all. 
    public static boolean isValidSpeed(int value) {
        return value >= 0 && value <= MAX_SPEED;
    }

}