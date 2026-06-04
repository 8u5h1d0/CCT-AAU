package emne4Polymorphism;

public class SuperDemo {

    public static void main(String[] args) {

        System.out.println("Creating Dog");
        DemoDog d = new DemoDog();
        
        System.out.println("\n");
        d.sound();
    }
}

// Superclass
class DemoAnimal {

    private String type;

    public DemoAnimal(String type) {
        this.type = type;
        System.out.println("Animal constructor: " + this.type + " created @");
        System.out.println(this + "\n");
    }
    
    public void sound() {
        System.out.println("Animal sound");
    }

}

// Subclass
class DemoDog extends DemoAnimal { // DemoDog IS-A(n) DemoAnimal

    public DemoDog() {
        super("Canine");
        System.out.println("Dog created @");
        System.out.println(this);
    }
    
    @Override
    public void sound() {
        super.sound();
        System.out.println("Dog bark");
    }
}