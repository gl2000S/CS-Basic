# Overriding

## In one sentence
A child class replaces a parent method with its own version, using the SAME name and
SAME parameters, and the object type decides which runs.

## Why it matters
- Each child customizes shared behavior (Car drives, Boat sails).
- Code written against the parent (List<Vehicle>) automatically runs
  each child's version.
- It's what makes runtime polymorphism work.

## Core rule
- Same name + same parameter list as the parent method.
- Which version runs is decided at RUNTIME by the OBJECT type.
  Vehicle car = new Car();
  car.move();   → object is Car → runs Car's move() → "drives on roads"
  Vehicle boat = new Boat();
  boat.move();  → Boat never overrode move() → runs Vehicle's version

## Rules the compiler enforces
| Rule                                      | Break it and...                   |
|----------------------------------------   |-----------------------------------|
| Same name and parameters                  | It becomes an OVERLOAD instead    |
| Same return type (or a subtype)           | "return type is not compatible"   |
| Same or WIDER access (public stays public) | "weaker access privileges"    |
| Parent method can't be final              | "overridden method is final"      |
| Parent method can't be private            | Child's method is just a new method |
| Parent method can't be static             | Child's static method HIDES it; no runtime dispatch |
| Constructors                              | Never overridden (not inherited)  |

## How in Java
- Put @Override above every overriding method; the compiler then verifies it really overrides something.
- super.method() calls the parent's version (reuse + extend).


## Overriding vs overloading
- Overriding: CHILD class, SAME parameters, decided at RUNTIME.
- Overloading: same class, DIFFERENT parameters, decided at COMPILE time.


## Interview answer
Overriding means a subclass provides its own version of a parent method with the same name and parameters. 
Which version runs is decided at runtime by the actual object, so with Vehicle v = new Car(), v.move() runs Car's version.
Always use @Override, because without it a typo or a different parameter list silently creates an overload instead.