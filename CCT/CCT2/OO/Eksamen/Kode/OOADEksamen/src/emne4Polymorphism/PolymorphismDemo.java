package emne4Polymorphism;

public class PolymorphismDemo {

    public static void main(String[] args) {

        System.out.println("STATIC POLYMORPHISM (OVERLOADING)");

        Calculator calc = new Calculator();

        System.out.println("int add: " + calc.add(2, 3));
        System.out.println("double add: " + calc.add(2.0, 3.0));


        System.out.println("\nDYNAMIC POLYMORPHISM (OVERRIDING)");

        Animal a1 = new Animal();
        Animal a2 = new Dog(); // polymorphism

        a1.speak(); // "Animal" version
        a2.speak(); // "Dog" version (runtime)
    }
}

// STATIC
class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }
}

// DYNAMIC
class Animal {

    public void speak() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    @Override
    public void speak() {
        System.out.println("Woof");
    }
}
