package oop.exceptions;

// ================= CUSTOM CHECKED EXCEPTION =================
// extends Exception (not RuntimeException) → CHECKED:
// the compiler forces callers to catch it or declare it.
public class InsufficientFundsException extends Exception {

    private final int shortBy; 

    public InsufficientFundsException(int shortBy) {
        super("Insufficient funds: short by " + shortBy);
        this.shortBy = shortBy;
    }

    public int getShortBy() {
        return shortBy;
    }
}
