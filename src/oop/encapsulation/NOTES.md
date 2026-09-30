# Encapsulation: 

## In one sentence
A class keeps its data private and controls every change to it,
so its objects can never end up in an invalid state. 

## Why it matters 
- Prevents invalid states (e.g. Car with year -500). 
- Lets me change the class internals without breaking coe tha uses it.
    - EX : private LocalDate manufactureDate;

            public int getYear() {
                return manufactureDate.getYear();   // computed, not stored
            } 
            // but car1.getYear() 


## How in Java 
- Fields 'private'
- Constructor makes sure every object starts valid 
- Setters VALIDATE input 
- Fields that should never change: 'final', no setter.

## Access modifiers 
| Modifier  | Who can access                     |
|-----------|------------------------------------|
| private   | Same class only                    |
| (none)    | Same package                       |
| protected | Same package + subclasses          |
| public    | Everyone                           |


## Examples 
Car.java: `model` and `year` are final (a car can't change them);
`setColor` rejects null.
Main.java: `car1.model = "X";` fails to compile. That error IS encapsulation.


## Interview answer
- "Encapsulation means keeping an object's data private and exposing
methods that control how it changes."
- "For example, a BankAccount's withdraw method rejects amounts larger than the balance, so the account can never go negative. It keeps objects valid and lets me change the internals without breaking the code that uses the class."