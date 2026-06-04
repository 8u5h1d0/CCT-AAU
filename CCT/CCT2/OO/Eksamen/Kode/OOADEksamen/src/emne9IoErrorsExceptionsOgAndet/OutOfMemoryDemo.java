package emne9IoErrorsExceptionsOgAndet;
import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryDemo {

    public static void main(String[] args) {

        List<byte[]> memoryHog = new ArrayList<>();

        try {

            while (true) {

                // Alloker 10 MB ad gangen
                memoryHog.add(new byte[10 * 1024 * 1024]);

                System.out.println(
                        "Allocated "
                        + memoryHog.size() * 10
                        + " MB");
            }

        } catch (OutOfMemoryError e) {
            System.out.println("This is an Error, not an Exception."); // Printer ikke
        }
    }
}
