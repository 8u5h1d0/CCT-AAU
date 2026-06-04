package emne6StruktureretData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionDemo {

    public static void main(String[] args) {

        System.out.println("USING ARRAYLIST");

        // Kode læner på "List", IKKE på "ArrayList"
        List<String> names = new ArrayList<>();

        names.add("Alice");
        names.add("Bob");

        System.out.println(names);
        for (String item : names) {
        	System.out.print("item: " + item + " | ");
        	System.out.println(
        		    Integer.toHexString(
        		        System.identityHashCode(item)
        		    )
        		);
        }

        System.out.println("\nSWITCHING TO LINKEDLIST");

        // "LinkedList" er også en "List"
        names = new LinkedList<>();

        names.add("Charlie");
        names.add("Dave");

        System.out.println(names);
        for (String item : names) {
        	System.out.print("item: " + item + " | ");
        	System.out.println(
        		    Integer.toHexString(
        		        System.identityHashCode(item)
        		    )
        		);
        }
    }
}