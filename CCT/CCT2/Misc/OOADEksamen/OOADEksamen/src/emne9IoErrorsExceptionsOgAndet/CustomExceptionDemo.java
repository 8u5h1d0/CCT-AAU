package emne9IoErrorsExceptionsOgAndet;

public class CustomExceptionDemo {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(100);

        System.out.println("=== CHECKED EXCEPTION ===");

        try {
            // Vi forsøger at hæve 150, men vi har kun 100.
            // Fordi metoden kaster en Checked Exception, TVINGER Java os til at bruge try-catch!
            account.withdrawChecked(150);
        } catch (InsufficientFundsException e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("Missing amount: " + e.getAmount());
        }

        System.out.println("\n=== UNCHECKED EXCEPTION ===");

        // Her forsøger vi at hæve 200. 
        // Fordi det er en Unchecked Exception, tvinger Java os ikke til at bruge try-catch.
        account.withdrawUnchecked(200);

        // DENNE LINJE BLIVER ALDRIG KØRT:
        System.out.println("Program continues...");
    }
}

// ==========================================
// DE MANGLENDE KLASSER (Tilføjet herunder)
// ==========================================

// 1. Vores egen Custom Checked Exception
// Fordi den arver fra "Exception", bliver den automatisk "Checked"
class InsufficientFundsException extends Exception {
    private double amount; // Ekstra attribut til at gemme det manglende beløb

    public InsufficientFundsException(String message, double amount) {
        super(message); // Sender beskeden op til superklassen (Exception)
        this.amount = amount;
    }

    // Domæne-specifik metode
    public double getAmount() {
        return amount;
    }
}

// 2. Bankkontoen
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Checked: Læg mærke til "throws" i signaturen. Vi advarer om at den KAN fejle.
    public void withdrawChecked(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            double deficit = amount - balance;
            throw new InsufficientFundsException("Du har ikke penge nok på kontoen!", deficit);
        }
        balance -= amount;
    }

    // Unchecked: Ingen "throws" advarsel i signaturen.
    public void withdrawUnchecked(double amount) {
        if (amount > balance) {
            // Vi kaster en standard Unchecked Exception (RuntimeException)
            throw new RuntimeException("Kritisk fejl: Overtrak kontoen med " + (amount - balance));
        }
        balance -= amount;
    }
}