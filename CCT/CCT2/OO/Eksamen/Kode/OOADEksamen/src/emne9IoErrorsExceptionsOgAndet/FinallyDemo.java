package emne9IoErrorsExceptionsOgAndet;

public class FinallyDemo {

    public static void main(String[] args) {

        System.out.println("=== 1. NORMAL TRY ===");

        try {
            System.out.println("Try block running");
        } finally {
            System.out.println("Finally always runs");
        }

        System.out.println("\n=== 2. TRY WITH EXCEPTION ===");

        try {
            System.out.println("Before exception");
            throw new RuntimeException("Something went wrong");
        } finally {
            System.out.println("Finally still runs");
        }
    }
}
