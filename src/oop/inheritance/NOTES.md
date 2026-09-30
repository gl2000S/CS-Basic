# Inheritance 

## In one Sentence
A child class reuses a parent class's field and method and 
can add or change behavior, modeling an "is-a" relationship.
(Car is a Vehicle). 

## Why it matters 
- Code reuse: Shared fields / methods are written once in the parent. 
- Shared type: a Dog can be used anyhwere an Animal is expected. 

## How in Java 
- A class can extend ONLY ONE class 
- Child constructor calls 'super(...)' FIRST to build the parent part
- @Override marks exist in the child object but can't be accessed by 
name ; use the parent's getters.
- Constructors are not inherited. 
- 'final class' cannot be extended 

## Key Terms 
| Term                          | Meaning                               |
|-------------------------------|---------------------------------------|
| Parent / superclass / base    | The class being extended              |
| Child / subclass / derived    | The class that extends it             |
| extends                       | Keyword that creates the relationship |
| super                         | Refers to the parent (constructor/methods) |
| Override                      | Child replaces a parent method        |


## The "is-a" test
- Dog is an Animal         → inheritance
- Car is an Engine         → wrong; a Car HAS an Engine → composition
  (store an Engine as a field instead)


## Interview answer
"Inheritance lets a class reuse and extend another class's fields and
methods. It models an is-a relationship, for example a Dog is an Animal,
so shared behavior lives in Animal and Dog adds or overrides what's
specific to it. I use it only when is-a is true; for has-a relationships
I use composition instead."