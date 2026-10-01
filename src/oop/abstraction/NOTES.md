# Abstraction 

## In one sentence
Abstraction exposes WHAT an obkect does and hodes HOW it does it, 
so code can use it without knowing the details 

## Why it matters 
- Callers depend on a simple contract, not on complex internals 
- Defferent classes can fulfill the same contract in their own way
    - Example : a driver calls accelerate(); the engine details are hidden. 


## How in Java : Two tools (Go in depth later)

### Abstract class 
- ' abstract class Vehicle '
- Cannot be instantiated, cannot be made an object 
- Can have abstract methods (no body) AND concrete methods (with body)
- Can have fields and constructors (children call them with super) 
- A class can extend only ONE abstract class 

### Interface Class 
- 'Interface Electric { void charge()}'
- Cannot be instantiated; cannot be made an object, has no constructor. 
- Methods are public and abstract by default , they can have a body 
- Fields are constants only (public static final). 
- A class can implement MANY interfaces 


## Abstract class vs Interface 
| Question                         | Abstract class | Interface  |
|----------------------------------|----------------|------------|
| Relationship                     | is-a           | can-do     |
| Fields (per-object state)        | Yes            | No (constants only) |
| Constructors                     | Yes            | No         |
| How many per class               | One            | Many       |
| Use when                         | Related classes share state/code | Unrelated classes share a capability |


## Abstraction vs Encapsulation 
- Encapsulation hides and protects data (private fields + validation) 
- Abstraction hides COMPLEXITY (simple methods, hiden implementaions) 

Ex. 
- Same car: 
    - 'private int speed = encapsulation'
    - 'calling accelerate() , without knowing how it works = abstraction' 


## Interview Answer 
Abstraction means exposing what an object does while hiding how it does it. 
In Java we use abstract classes when related classes share state or code, 
like an abstract Vehicle with a shared accelerate() and an abstract getWheels().
A class can extend one abstract class but implement many interfaces. 