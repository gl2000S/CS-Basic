# Static vs Instance

## In one sentence
Instance members belong to EACH object (every Car has its own speed). 
Static members belong to the CLASS itself (one carsBuilt shared by all).

## Why it matters
- Static fields hold data shared across all objects (counters, constants).
- Static methods work without creating an object (Math.max, Car.isValidSpeed).
- Explains the most common beginner error: "non-static ... cannot be referenced from a static context".

## The core rule
- Static code has NO object, so it has no `this` and can't touch instance fields or instance methods directly.
- Instance code runs ON an object, so it can use BOTH.
    static int getCarsBuilt() { return carsBuilt; }  → fine (static field)
    static int getCarsBuilt() { return speed; }      → error: WHICH car's speed?

## Comparison
|               | Instance                           | Static |
|---            |---                                 |---|
| Belongs to    | Each object                        | The class |
| Copies        | One per object                     | One total |
| Called with   | object.method() → a.accelerate(50) | Class.method() → Car.getCarsBuilt() |
| Has `this`    | Yes                                | No |
| Can access    | Instance + static members          | Static members only |
| Example       | name, speed, describe()            | carsBuilt, MAX_SPEED, isValidSpeed() |

## How in Java
- Add `static` to a field or method to make it belong to the class.
- Constants: `public static final int MAX_SPEED = 200;` 
- Call static members with the CLASS name: Car.MAX_SPEED, Math.min(...)
- Static methods can't be overridden, only hidden.

## When to use static
- Shared data across all objects: counters, constants.
- Utility methods that need no object data: Math.max, isValidSpeed.
- Otherwise default to instance: most data belongs to a specific object.


## Interview answer
Instance members belong to each object, like each Car's own speed.
Static members belong to the class and are shared, like a counter of how many cars were built. 
A static method has no object, so it can't access instance fields; that's why main, which is static, can only call static helpers directly.
Use static for constants, shared counters, and utility methods that don't depend on object state, and instanc members for everything that's specific to one object.