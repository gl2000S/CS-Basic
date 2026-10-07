package oop.polymorphism.overloading;

public class Main {
    
    public static void main(String[] args) { 
        
        Calculator calc = new Calculator(); 

        // 1. Java matches the ARGUMENTS to a parameter list.
        System.out.println(calc.add(2, 3));
        System.out.println(calc.add(19, 20, 21));
        System.out.println(calc.add(23.5, 42.0));


        // 2. no add (int,double) version exists, so Java 
        // will promote the int to a double and call add(double,double). 
        System.out.println(calc.add(2,3.0));


        // 3. Parameter ORDER decides the version. 
        System.out.println(calc.describe("Food Score: ", 8));
        System.out.println(calc.describe(5, "Points."));

        // 4. Constructor OVERLOADING
        System.out.println(new Coffee());
        System.out.println(new Coffee("Medium"));
        System.out.println(new Coffee("Large", true));

        // 5. overloading is not just for methods and constructors.
        System.out.println(42);
        System.out.println("42");



    }
}
