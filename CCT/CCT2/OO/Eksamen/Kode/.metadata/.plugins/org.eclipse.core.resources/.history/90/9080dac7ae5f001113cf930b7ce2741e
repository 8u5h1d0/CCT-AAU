package emne2KlasserOgRelationer;

public class SuperDemo {

	public static void main(String[] args) {

	        System.out.println("Creating Dog");
	        Dog d = new Dog();
	        System.out.println("\n");
	        d.sound();
	    }
	}


	// Superclass
	class Animal {

	    private String type;

	    public Animal(String type) {
	        this.type = type;
	        System.out.println("Animal constructor: " + this.type + " created @");
	        System.out.println(this + "\n");
	    }
	    
	    public void sound() {
	        System.out.println("Animal sound");
	    }

	}


	// Subclass
	class Dog extends Animal { //Dog IS-A(n) Animal

	    public Dog() {
	        super("Canine");
	        System.out.println("Dog created @");
	        System.out.print(this);
	    }
	    
	    @Override
	    public void sound() {
	    	super.sound();
	        System.out.println("Dog bark");
	    }
	}