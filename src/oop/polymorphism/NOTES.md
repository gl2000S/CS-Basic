# Polymorphism 

## In one sentence 
One method call behaves differently depending on the actual object, 
so the same code works with many types (many forms). 

## Why it matters 
- One loop over a List<Vehicle> works for cars, boats, and any other vehicle created in the future. 
- Adding a new class (Plane) need NO changes to code that uses Vehicle. 

## The core rule 
- VARIABLE type decides what I can CALL (compile time )
- OBJECT type decides WHICH VERSION runs (runtime)

Ex. 
Vehicle v = new Car("TOYOTA"); 
v.move() -> compiles (Vehicle has move()) -> runs Car's move
v.honk() -> compile error (Vehicle has no honk())


## Two kinds (More Later)

|                   | Overriding                        | Overloading |
|---|---|---|
| Also called       | Runtime polymorphism              | Compile-time polymorphism |
| What changes      | Method body, in a child class     | Parameter list, same class |
| Decided by        | Object type, at runtime           | Arguments, at compile time |
| Example           | move() in Car and Boat            | travel(int) and travel(int, String) |


## How in Java
- OVerride parent methods with @OVerride (need inheritance or an interface) 
- Use the parent type for variables, lists, and method paramenters. 
    - Vehicle v, List<Vehicle>, startTrip(Vehicle v). 
-  Works through interfaces too: Electric e = new ElectricCar(); 
- To call a child-only method, check and cast first: 
    - if (v instanceof Car car) { car.honk(); }

## Polymorphism vs Inheritance
- Inheritance: a child REUSES the parent's code ()
    - Car gets accelerate()
- Polymorphism : one call RUNS DIFFERENT code per object 
    - v.move()
- Inheritance (or interface) is what MAKES polymorphism possible. 

 ## Interview answer 
 Polymorphism means one method call can behave differently depending on the object. 
 For example: 
-  With a List<Vehicle> holding cars, boat, and planes. 
- calling move() on each own version. 
- The variabel type decides what i can call , and the object type decides 
which version runs. 


