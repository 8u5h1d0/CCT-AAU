package emne5Interfacer;

//Kontrakt
interface PaymentProcessor {

 void processPayment(double amount);
}

//Team A implementering
class PayPalProcessor implements PaymentProcessor {

 @Override
 public void processPayment(double amount) {
     System.out.println("PayPal processing payment: " + amount);
 }
}

//Team B implementering
class StripeProcessor implements PaymentProcessor {

 @Override
 public void processPayment(double amount) {
     System.out.println("Stripe processing payment: " + amount);
 }
}

public class DesignByContractDemo {

    public static void main(String[] args) {

        System.out.println("Team C (Bruger Team A´s & B´s kode-under-kontrakten)");

        PaymentProcessor paypal = new PayPalProcessor();
        PaymentProcessor stripe = new StripeProcessor();

        processOrder(paypal, 100);
        processOrder(stripe, 250);
    }

    // Team C code
    public static void processOrder(PaymentProcessor processor, double amount) {
        processor.processPayment(amount);
    }
}


