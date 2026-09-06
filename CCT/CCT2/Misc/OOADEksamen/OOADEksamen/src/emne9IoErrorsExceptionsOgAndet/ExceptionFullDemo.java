package emne9IoErrorsExceptionsOgAndet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExceptionFullDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 1. BAD: Exceptions as control flow ===");
        Scanner scanner1 = new Scanner("1 2 3 x 4");
        while (true) {
            try {
                System.out.println(scanner1.nextInt());
            } catch (Exception e) {
                System.out.println("Stopping loop (caught exception)");
                break;
            }
        }

        System.out.println("\n=== 1. BETTER: Normal control flow ===");
        Scanner scanner2 = new Scanner("1 2 3 x 4");
        while (scanner2.hasNextInt()) {
            System.out.println(scanner2.nextInt());
        }
        System.out.println("Done scanning numbers.");

        System.out.println("\n=== 2. BAD: Exceptions for expected conditions ===");
        Map<String, String> map1 = new HashMap<>();
        map1.put("A", "Apple");
        try {
            System.out.println(map1.get("B").toString());
        } catch (NullPointerException e) {
            System.out.println("Key missing (caught NullPointerException)");
        }

        System.out.println("\n=== 2. BETTER: Check first ===");
        Map<String, String> map2 = new HashMap<>();
        map2.put("A", "Apple");
        if (map2.containsKey("B")) {
            System.out.println(map2.get("B"));
        } else {
            System.out.println("Key missing (safe check)");
        }

        System.out.println("\n=== 3. BAD: Swallowing exceptions ===");
        try {
            int x = 10 / 0;
        } catch (Exception e) {
            // ❌ Swallowed exception
        }
        System.out.println("Program still running (bug hidden)");

        System.out.println("\n=== 3. BETTER: Handle properly ===");
        try {
            int x = 10 / 0;
        } catch (Exception e) {
            System.err.println("Error caught: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Program continues after proper handling");

        System.out.println("\n=== 4. Finally block demo ===");
        try {
            System.out.println("Inside try block");
            throw new RuntimeException("Something went wrong");
        } finally {
            System.out.println("Finally always executes");
        }
    }
}
