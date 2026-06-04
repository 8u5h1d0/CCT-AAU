package emne1KlasserGenerelt;

public class ImperativeVsOOPDemo {

    public static void main(String[] args) {

        System.out.println("IMPERATIVE");

//      Type   Variabel  Værdi (Som i C)
        double balance = 100; //Primitiv data type

        System.out.printf("Før deposit: %.2f%n",
                          balance);

        balance = deposit(balance, 50);

        System.out.printf("Efter deposit: %.2f%n",
                          balance);

        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println();

        System.out.println("OOP");

//      Type        Reference Contructor Call    Object
        BankAccount account = new                BankAccount(100);

        System.out.println("Før deposit: " + account.getBalance()); //overloaded '+' operator

        account.deposit(50);

        System.out.printf("Efter deposit: " + account.getBalance()); //overloaded '+' operator
    }

    public static double deposit(double balance,
                                 double amount) {

        return balance + amount;
    }
}

class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}