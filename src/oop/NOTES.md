
OOP 

What is OOP? 
- OOP is a programming model built around objects rather than actions. 


Why do we use OOP? 
- it helps structure and organize code by grouping data and actions into the object. 


What is a class? 
- is a blueprint or template for creating objects 

What is an object? 
- An instance of a class (concrete object created from a class)


Creating an Objects and Assigning a value: 

public class Student {
	String name; 
}

public class Main { 
	public static void main(String args[]) { 
		
		//Creating an object 
		Student student1 = new Student(); 
		
		// Assigning object a value. 
		student1.name = "Raul"; 
		
		System.out.println(student1.name); 
	}
}  
