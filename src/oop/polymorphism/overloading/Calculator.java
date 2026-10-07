package oop.polymorphism.overloading;

// OVERLOADING = same method name, DIFFERENT PARAMETER LIST, same class 
public class Calculator {

    // Version 1 = two ints 
    public int add (int a, int b) { 
        System.out.println("[int, int]");
        return a + b;
    }

    // Version 2 = three ints
    public int add (int a, int b, int c) { 
        System.out.println("[int, int, int]");
        return a + b + c;

    }

    // Version 3 = two doubles
    public double add (double a, double b) { 
        System.out.println("[double, double]");
        return a + b;
    }


    //  Different ORDER of parameter types count as a different list.
    public String describe(String label, int value) { 
        return label + " = " + value;
    }

    public String describe(int value, String unit) {
        return value + " " + unit;
    }

}
