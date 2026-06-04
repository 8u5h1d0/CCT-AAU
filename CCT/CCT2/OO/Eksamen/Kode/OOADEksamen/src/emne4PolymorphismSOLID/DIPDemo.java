
package emne4PolymorphismSOLID;

public class DIPDemo { //Dependency Inversion Principle

    public static void main(String[] args) {

        Engine petrol = new PetrolEngine();
        Engine electric = new ElectricEngine();

        Car car1 = new Car(petrol);
        Car car2 = new Car(electric);

        car1.start();
        car2.start();
    }
}

interface Engine {
    void start();
}

class PetrolEngine implements Engine {
    public void start() {
        System.out.println("Petrol engine starting");
    }
}

class ElectricEngine implements Engine {
    public void start() {
        System.out.println("Electric engine starting");
    }
}

//Højere kode (Car) bør ikke være afhængig af lavere (PetrolEngine, ElectricEngine)
// Begge bør benytte en abstraktion (Engine)
class Car {

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
    }
}
