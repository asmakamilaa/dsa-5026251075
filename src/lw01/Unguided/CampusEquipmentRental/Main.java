package lw01.Unguided.CampusEquipmentRental;
//Module 01: Object-Oriented Programming
//Assessed Lab Case: Campus Equipment Rental

import java.io.FileNotFoundException;
import java.util.*;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(
            Main.class.getResourceAsStream("/lw01/Unguided/rentals.txt")
        );

        int t = scanner.nextInt();

        Rental[] rentals = new Rental[t];

        for (int i = 0; i < t; i++) {
            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            int units = scanner.nextInt();

            Rental rental;

            if (type.equals("PROJECTOR")) {
                rental = new ProjectorRental(id, days, units);
            } else if (type.equals("LAPTOP")) {
                rental = new LaptopRental(id, days, units);
            } else {
                throw new IllegalArgumentException("Invalid rental type: " + type);
            }

            rentals[i] = rental;
            
        }

        scanner.close();

        for (Rental rental : rentals) {
            System.out.println(rental.summary());
        }
    }
}