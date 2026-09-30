package oop.inheritance;

public class Motorcycle extends Vehicle {

    private final String type; 

    public Motorcycle(String brand, int year, String type) {
        super(brand, year);
        this.type = type;
    }

    public String getType() { 
        if (type == null || type.isEmpty()) { 
            throw new IllegalArgumentException("Type cannot be null or empty");
        }
        return type; 
    }

    @Override 
    public String honk() { 
        return "Ma Ma";
    }
    
}
