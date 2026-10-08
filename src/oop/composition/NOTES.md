# Composition (vs Inheritance)

## In one sentence
Inheritance says a class IS A kind of another class; 
Composition says a class HAS another object as a field and hands work to it.

Ex. 
class Engine {
    String start() { return "Vroom"; }
}

class Car {
    private Engine engine = new Engine();   // Car HAS an Engine (a field)

    String start() {
        return engine.start();              // Car asks its engine to do the work
    }
}

## Why it matters
- Composition lets me swap parts at runtime (gas engine → electric motor).
- A class can hold many components, but extend only one class.
    - With composition, the class exposes only the methods I choose;
    inheritance exposes ALL the parent's public methods, wanted or not.

    Ex. 
    class Car {
        private Engine engine;     // component 1
        private GPS gps;           // component 2
        private Radio radio;       // component 3
        private Tire[] tires;      // component 4 (an array of 4 tires)
    }

## The core rule
- Ask "is-a" or "has-a"?
  Dog is an Animal       → inheritance
  Car has an Engine      → composition
  Car is an Engine?      → false → never use extends here

- Even when is-a is true: if I just want to REUSE code, prefer composition.

- Use inheritance when the child can truly be used ANYWHERE the parent is
  expected (a Dog works wherever an Animal is needed).

## Comparison
|               | Inheritance                   | Composition |
|---            |---                            |---          |
| Relationship  | is-a                          | has-a       |
| Java syntax   | `class Car extends Vehicle`   | `private Engine engine;` field |
| Decided       | Compile time (fixed)          | Runtime (swappable) |
| How many      | One parent class              | Any number of components |
| Exposes       | All parent's public methods   | Only methods I write |

Ex. Swappable 
    Car commuter = new Car("Commuter", new GasEngine());
    System.out.println(commuter.start());      // Commuter: Vroom (gas engine)

    commuter.swapEngine(new ElectricMotor());  // replace the part
    System.out.println(commuter.start());      // Commuter: Whirr (electric motor)

## How in Java
- Store the other object in a private field.
- DELEGATE: my method calls the component's method (engine.start()).
- Make the field's type an INTERFACE (Engine) so any implementation fits.
- Provide a setter or method to swap the part if needed (swapEngine).


## Interview answer
Inheritance models an is-a relationship, like a Dog is an Animal.
Composition models has-a: a Car has an Engine stored as a field and delegates to it. 
Generally favor composition because it's more flexible: 
    - I can swap components at runtime, 
    - combine several of them,
    - and expose only the methods I want.
Still use inheritance when the is-a relationship is genuine and the subclass works anywhere the parent is expected.