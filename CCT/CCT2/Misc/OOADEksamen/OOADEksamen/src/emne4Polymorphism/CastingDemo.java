package emne4Polymorphism;

public class CastingDemo {

    public static void main(String[] args) {

        System.out.println("1. UPCASTING (IMPLICIT)");

        PolyBicycle b1 = new PolyBicycle();
        PolyVehicle v1 = b1; // Upcasting

        // Selvom den ligger i en "Vehicle" variabel, VED den at den er en cykel. 
        //(en "cykel" er også et "vehicle")
        v1.move(); 


        System.out.println("\n2. DOWNCASTING (EXPLICIT)");

        PolyVehicle v2 = new PolyBicycle(); // Upcast først
        
        // "Jeg lover, at v2 faktisk er en cykel"
        PolyBicycle b2 = (PolyBicycle) v2;   
        
//        if (v2 instanceof PolyBicycle)
//        	PolyBicycle b2 = (PolyBicycle) v2;
//        else
//        	throw ClassCastException;
        	
        // Nu kan vi kalde cykel-specifikke metoder!
        b2.pedal();


        System.out.println("\n3. DANGEROUS CAST (RUNTIME ERROR)");

        PolyVehicle v3 = new PolyCar();

        // PolyBicycle b3 = (PolyBicycle) v3;

        System.out.println("Tjekker typen med 'instanceof' før vi caster...");

        if (v3 instanceof PolyBicycle) {
            PolyBicycle safeBike = (PolyBicycle) v3;
            safeBike.pedal();
        } else {
            System.out.println("v3 er IKKE en cykel → vi afbryder for at undgå et crash!");
        }
    }
}

// SUPERCLASS
class PolyVehicle {
    public void move() {
        System.out.println("Vehicle moving");
    }
}

// SUBCLASS 1
class PolyBicycle extends PolyVehicle {
    @Override
    public void move() {
        System.out.println("Bicycle moving");
    }

    public void pedal() {
        System.out.println("Bicycle pedaling");
    }
}

// SUBCLASS 2
class PolyCar extends PolyVehicle {
    @Override
    public void move() {
        System.out.println("Car driving");
    }
}