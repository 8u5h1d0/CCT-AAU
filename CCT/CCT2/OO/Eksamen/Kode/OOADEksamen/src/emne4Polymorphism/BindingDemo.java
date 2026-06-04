package emne4Polymorphism;

public class BindingDemo {

    public static void main(String[] args) {

        System.out.println("STATIC BINDING");

        Bicycle b = new Bicycle();
        b.move(); // compiler ved hvilken Bicycle.move()


        System.out.println("\nDYNAMIC BINDING - Late Binding");

        Vehicle v = new Bicycle(); // upcasting

        v.move(); // runtime vælger move() passende til objektet
    }
}

// SUPERCLASS
class Vehicle {

    public void move() {
        System.out.println("Vehicle is moving");
    }
}

// SUBCLASS
class Bicycle extends Vehicle {

    @Override
    public void move() {
        System.out.println("Bicycle is moving");
    }
}
