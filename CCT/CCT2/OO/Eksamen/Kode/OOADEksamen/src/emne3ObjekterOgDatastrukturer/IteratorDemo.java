package emne3ObjekterOgDatastrukturer;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        System.out.println("Før fjernelse");

        Iterator<String> it1 = names.iterator();

        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

		// Fjerner Bob
        Iterator<String> it2 = names.iterator();

        while (it2.hasNext()) {

            String name = it2.next();

            if (name.equals("Bob")) {
                it2.remove();
            }
        }

        System.out.println("\nEfter fjernelse");
        System.out.println(names);
    }
}