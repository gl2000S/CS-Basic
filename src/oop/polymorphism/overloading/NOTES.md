# Overloading 

## In one sentence
Several methods in the SAME class share one name but have DIFFERENT parameter lists,
and Java picks the right one based on the arguments. 

## Why it matters 
- One name for one idea: add(...), instead of addInt, addDouble, addThree. 
- Callers don't need to remember several method names 
- Constructor can offer defaults. 

## Core rule 
- The COMPILER picks the version by matching ARGUMENT types. 
- Exact match first: if none, Java widens (int -> double) , not narrow. 
- Return tyope is IGNORED when picking a version. 
  calc.add(2, 3);      → exact match → runs add(int, int) → 5
  calc.add(2, 3.0);    → no add(int, double) → widens 2 to 2.0
                       → runs add(double, double) → 5.0
  calc.add(2.5, 3.5);  → if only add(int, int) exists → compile error
                         (double can't narrow to int automatically)


## What counts as a different parameter list
| Difference            | Example                                           | Valid? |
|-----------------------|----------------------------------------           |-----|
| Number of parameters  | add(int, int) vs add(int, int, int)               | Yes |
| Type of parameters    | add(int, int) vs add(double, double)              | Yes |
| Order of types        | describe(String, int) vs describe(int, String)    | Yes |
| Return type only      | int add(int, int) vs double add(int, int)         | No  |
| Parameter names only  | add(int a, int b) vs add(int x, int y)            | No  |

## Overloading vs Overriding 
- Overloading : same name, DIFFERENT parameter, decided at COMPILE time. 
- Overriding : same name AND same parameter in a CHILD class, decided at RUNTIME by object type. 

## Interview Answer: 
Overloading means several methods in the same class share a name but have different parameter lists, 
by number, type, or order of parameters. 
The compiler picks which one to call based on the arguments, so it's compile-time polymorphism. 
A common example is println, which has a version for each type, and overloaded constructors 
that provide default values. 