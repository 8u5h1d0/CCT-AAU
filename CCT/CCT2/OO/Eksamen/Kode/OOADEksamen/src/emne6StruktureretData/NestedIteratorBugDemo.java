package emne6StruktureretData;

import java.util.ArrayList;
import java.util.Iterator;

public class NestedIteratorBugDemo {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Anna");
        names.add("David");

        System.out.println("1. BROKEN NESTED LOOP");
        brokenNestedLoop(names);

        System.out.println("\n2. SKIP BUG (double next)");
        skipBug(names);

        System.out.println("\n3. CORRECT ITERATOR");
        correctIterator(names);

        System.out.println("\n4. FOR-EACH (BEST)");
        forEach(names);
    }

    //Fejl i nested loop
    public static void brokenNestedLoop(ArrayList<String> names) {

        Iterator<String> outer = names.iterator();

        while (outer.hasNext()) {

            System.out.println("OUTER: " + outer.next());

            while (outer.hasNext()) {

                System.out.println("INNER: " + outer.next());
            }
        }
    }

    //2. Skip Bug (double next())
    public static void skipBug(ArrayList<String> names) {

        Iterator<String> outer = names.iterator();

        while (outer.hasNext()) {

            if (outer.next().startsWith("A")) {

                //second next() skips elements
                System.out.println("MATCH: " + outer.next());
            }
        }
    }

    //3. Korrekt iterator
    public static void correctIterator(ArrayList<String> names) {

        Iterator<String> it = names.iterator();

        while (it.hasNext()) {

            String current = it.next();
            System.out.println(current);
        }
    }

    //4. For-each
    public static void forEach(ArrayList<String> names) {

        for (String name : names) {
            System.out.println(name);
        }
    }
}