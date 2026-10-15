# Exceptions

## In one sentence
An exception is an object that signals something went wrong; it stops normal execution and travels up the call stack until a catch handles it (or the program crashes).

## Why it matters
- Separates error handling from normal code.
- Forces callers to deal with expected failures (checked exceptions).
- Validation in setters/constructors throws IllegalArgumentException (connects to encapsulation: this is how the class REFUSES bad input).

## The core rule
- When an exception is thrown, the rest of the try block is SKIPPED.
- Java looks for a matching catch in the current method; if none, the exception PROPAGATES to the caller, and so on up to main.
- If nothing catches it → program crashes with a stack trace.
    transfer() calls withdraw() → withdraw throws → transfer has no catch → exception goes to main → main's catch runs; "Transfer done" never prints

## Hierarchy
  Throwable
  ├── Error                   (JVM problems: StackOverflowError, OutOfMemoryError; don't catch)
  │                            
  └── Exception               CHECKED
      ├── IOException, my InsufficientFundsException
      
      └── RuntimeException    UNCHECKED
          ├── IllegalArgumentException
          ├── NullPointerException
          ├── ArithmeticException
          ├── NumberFormatException
          └── ArrayIndexOutOfBoundsException

## Checked vs unchecked
|                           | Checked                                       | Unchecked |
|---                        |---                                            |---|
| Extends                   | Exception                                     | RuntimeException |
| Compiler forces handling? | Yes (catch or `throws`)                       | No |
| Means                     | Expected situation the caller should handle   | Usually a programming bug |
| Example                   | InsufficientFundsException, IOException       | IllegalArgumentException, NullPointerException |

## throw vs throws
|           | throw                                         | throws |
|---        |---                                            |---|
| Where     | Method BODY                                   | Method SIGNATURE |
| Does      | Actually throws an exception now              | Warns callers it MAY throw |
| Example   | `throw new IllegalArgumentException("...")`   | `void withdraw(int a) throws InsufficientFundsException` |

## How in Java
- try { risky code } catch (SpecificException e) { handle } finally { always runs }
- Multiple catches: most SPECIFIC first, general (Exception) last.
- Custom exception: extend Exception (checked) or RuntimeException (unchecked); pass the message to super(message).
- e.getMessage() → the message; the stack trace shows where it happened.
- try-with-resources: try (Receipt r = new Receipt()) { ... } → r.close() runs automatically, BEFORE the catch block.



## Interview answer
An exception is an object signaling an error. 
When one is thrown, normal execution stops and it propagates up the call stack until a catch block handles it. 
Checked exceptions extend Exception, and the compiler forces callers to catch or declare them; Use them for expected situations, like insufficient funds. 
Unchecked exceptions extend RuntimeException and usually signal bugs, like an invalid argument. finally always runs, and try-with-resources closes resources automatically.