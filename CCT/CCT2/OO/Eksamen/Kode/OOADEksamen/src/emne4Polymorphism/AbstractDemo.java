package emne4Polymorphism;

public class AbstractDemo {

    public static void main(String[] args) {

    	// Vil ikke virke
        // Shape s = new Shape();
    	
        Shape s1 = new Circle();
        Shape s2 = new Rectangle();

        System.out.println("Circle");
        s1.printInfo();
        System.out.println("Area = " + s1.area());

        System.out.println("\nRectangle");
        s2.printInfo();
        System.out.println("Area = " + s2.area());
    }
}

abstract class Shape {

    // abstrakt method SKAL implementeres af alle subclasses
    public abstract double area();

    // konkret method (delt logik)
    public void printInfo() {
        System.out.println("I am a shape");
    }
}

// SUBCLASS 1
class Circle extends Shape {

    private double radius = 10;

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// SUBCLASS 2
class Rectangle extends Shape {

    private double width = 10;
    private double height = 20;

    @Override
    public double area() {
        return width * height;
    }
}
