package lw01.Unguided;
//Module 01: Object-Oriented Programming
//Assessed Lab Case: Campus Equipment Rental

import java.io.FileNotFoundException;
// import java.io.File;
import java.util.Array;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        Rental[] rentals = new Rental[100];

        Scanner scanner = new Scanner(
            Main.class.getResourceAsStream("/lw01/Unguided/rentals.txt")
        );

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            int units = scanner.nextInt();

            Rental rental;

            if (type.equals("PROJECTOR")) {
                rental = new ProjectorRental(id, days);
            } else {
                rental = new LaptopRental(id, days);
            } 
            rentals[i] = rental;
        }

        scanner.close();

        for (Rental rental : rentals) {
            System.out.println(rental.summary());
        }
    }
}