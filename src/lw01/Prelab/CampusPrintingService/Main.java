//Module 01: Object-Oriented Programming
//Prelab Case: Campus printing service

package CampusPrintingService;
import java.io.FileNotFoundException;
// import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        List<PrintJob> jobs = new ArrayList<>();

        Scanner scanner = new Scanner(
            Main.class.getResourceAsStream("/lw01/Prelab/jobs.txt")
        );

        // File file = new File("src/lw01/Prelab/CampusPrintingService/jobs.txt");
        // Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String type = scanner.next();
            String id = scanner.next();
            int pages = scanner.nextInt();

            PrintJob job;

            if (type.equals("MONO")) {
                job = new MonoPrint(id, pages);
            } else {
                job = new ColourPrint(id, pages);
            } 
            jobs.add(job);
        }

        scanner.close();

        for (PrintJob job : jobs) {
            System.out.println(job.summary());
        }
    }
}