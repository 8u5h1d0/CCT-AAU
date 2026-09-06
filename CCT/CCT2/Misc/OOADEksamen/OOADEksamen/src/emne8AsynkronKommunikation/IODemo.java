package emne8AsynkronKommunikation;

import java.io.*;

public class IODemo {

    public static void main(String[] args) {

        System.out.println("1. BYTE STREAM (binary data)");

        try (InputStream in = new FileInputStream("image.jpg")) {

            System.out.println("Reading binary file...");
            int firstByte = in.read(); // Læser 1 byte
            System.out.println("First byte: " + firstByte);

        } catch (IOException e) {
            System.out.println("File not found or error reading binary file");
        }


        System.out.println("\n2. CHARACTER STREAM (text data)");

        try (Reader reader = new FileReader("notes.txt")) {

            System.out.println("Reading text file...");
            int ch = reader.read(); // Læser 1 character (Unicode)
            System.out.println("First char code: " + ch);

        } catch (IOException e) {
            System.out.println("File not found or error reading text file");
        }


        System.out.println("\n3. BUFFERED READER (fast reading)");

        try (BufferedReader br =
        			 // Buffered fortæller fileReader
                     new BufferedReader(new FileReader("data.txt"))) {

            System.out.println("Reading line:");
            System.out.println(br.readLine());

        } catch (IOException e) {
            System.out.println("Error reading buffered file");
        }


        System.out.println("\n4. TRY-WITH-RESOURCES");

        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Line: " + line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file");
        }

        System.out.println("Done (auto-closed resources)");
    }
}