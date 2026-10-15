package oop.exceptions;

public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount(100);

        try { 
            account.withdraw(30);
            System.out.println("Withdrew 30, balance: " + account.getBalance());
            account.withdraw(100);                        // throws here...
            System.out.println("This line never runs");   // ...so this is skipped
        } catch (InsufficientFundsException e) {
            System.out.println("Caught: " + e.getMessage());
            System.out.println("Short by: " + e.getShortBy());
        } finally {
            // ALWAYS runs: exception or not.
            System.out.println("Finally: balance is " + account.getBalance());
        }

        // 2. Catching an UNCHECKED exception (optional, but possible)
        try {
            account.deposit(-50);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // 3. MULTIPLE CATCH BLOCKS with built-in unchecked exceptions
        String[] inputs = {"25", "abc", "0"};
        for (String input : inputs) {
            try {
                int value = Integer.parseInt(input);   // "abc" → NumberFormatException
                System.out.println("100 / " + value + " = " + (100 / value));   // 0 → ArithmeticException
            } catch (NumberFormatException e) {
                System.out.println("Not a number: " + input);
            } catch (ArithmeticException e) {
                System.out.println("Can't divide by zero");
            }
        }

        // 4. PROPAGATION: transfer() doesn't catch, so the exception travels UP to main.
        try {
            transfer(account, 500);
        } catch (InsufficientFundsException e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }

        // 5. TRY-WITH-RESOURCES: the receipt closes automatically, even on an exception.
        try (Receipt receipt = new Receipt()) {
            receipt.print("Balance " + account.getBalance());
            account.withdraw(1000);
        } catch (InsufficientFundsException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // account.withdraw(10);   // compile error: unreported exception; must be caught or declared
    }

    // Declares "throws" instead of catching → passes the exception to its caller.
    static void transfer(BankAccount from, int amount) throws InsufficientFundsException {
        System.out.println("Starting transfer of " + amount);
        from.withdraw(amount);
        System.out.println("Transfer done");   // skipped when withdraw throws
        }
    }



// ================= CLASS THAT THROWS =================
class BankAccount {
    private int balance;

    BankAccount(int balance) {
        if (balance < 0) {
            // UNCHECKED: a caller passing a negative balance is a programming bug.
            throw new IllegalArgumentException("Starting balance can't be negative");
        }
        this.balance = balance;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive: " + amount);
        }
        balance += amount;
    }

    // "throws" in the SIGNATURE = this method MAY throw this checked exception.
    // "throw" in the BODY = actually throw one now.
    public void withdraw(int amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive: " + amount);
        }
        if (amount > balance) {
            // CHECKED: not a bug, an expected situation the caller should handle.
            throw new InsufficientFundsException(amount - balance);
        }
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}


// ================= RESOURCE FOR TRY-WITH-RESOURCES =================
// Anything that implements AutoCloseable gets closed AUTOMATICALLY.
class Receipt implements AutoCloseable {
    Receipt() {
        System.out.println("Receipt opened");
    }

    void print(String line) {
        System.out.println("Receipt: " + line);
    }

    @Override
    public void close() {
        System.out.println("Receipt closed");
    }
}
