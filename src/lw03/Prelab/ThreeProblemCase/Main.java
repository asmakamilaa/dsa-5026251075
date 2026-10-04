package lw03.Prelab.ThreeProblemCase;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Problem 1: Playlist Management
        List<String> playlist = new ArrayList<>();

        Scanner playlistScanner = new Scanner(
            Main.class.getResourceAsStream("/lw03/Prelab/playlist.txt")
        );

        while (playlistScanner.hasNextLine()){
            String line = playlistScanner.nextLine();
            String[] parts = line.split(" ",2);

            String operation = parts[0];
            
            if(operation.equals("ADD")){
                String song = parts[1];
                playlist.add(song);

            } else if(operation.equals("INSERT")){
                String[] insertParts = line.split(" ", 3);
                
                int index = Integer.parseInt(insertParts[1]);
                String song = insertParts[2];

                playlist.add(index, song);
            } else if(operation.equals("REMOVE")){
                String song = parts[1];
                
                if(playlist.contains(song)){
                    playlist.remove(song);
                }
            }
        }

        playlistScanner.close();

        System.out.println("\n===== Problem 1 =====");
        System.out.println("Total song: " + playlist.size());

        for(int i = 0; i < playlist.size(); i++){
            System.out.println((i+1) + ": " + playlist.get(i));
        }


        //Problem 2: Unique Participants
        Set<String> participants = new LinkedHashSet<>();

        Scanner participantsScanner = new Scanner(
            Main.class.getResourceAsStream("/lw03/Prelab/participants.txt")
        );

        int duplicateRegistrations = 0;

        while(participantsScanner.hasNextLine()){
            String name = participantsScanner.nextLine();

            if(participants.contains(name)){
                duplicateRegistrations++;
            } else {
                participants.add(name);
            }
        }

        participantsScanner.close();

        System.out.println("\n===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());
        
        int number = 1;

        for(String name: participants){
            System.out.println(number + ". " + name);
            number++;
        }

        System.out.println("Duplicate registrations: " + duplicateRegistrations);

        //Problem 3: inventory
        Map<String, Integer> inventory = new LinkedHashMap<>();

        Scanner inventoryScanner = new Scanner(
            Main.class.getResourceAsStream("/lw03/Prelab/inventory.txt")
        );

        int failedSales = 0;

        while(inventoryScanner.hasNextLine()){
            String line = inventoryScanner.nextLine();
            String[] parts = line.split(" ");

            String type = parts[0];
            String itemName = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if(type.equals("ADD")){
                if(inventory.containsKey(itemName)){
                    int currentStock = inventory.get(itemName);
                    inventory.put(itemName, currentStock + quantity);
                } else {
                    inventory.put(itemName, quantity);
                }

            } else if (type.equals("SELL")){
                if(inventory.containsKey(itemName)){
                    int currentStock = inventory.get(itemName);

                    if(currentStock >= quantity){
                        inventory.put(itemName, currentStock - quantity);
                    } else {
                        failedSales++;
                    }
                } else {
                    failedSales++;
                }
            } 
        }

        inventoryScanner.close();

        System.out.println("\n===== Problem 3 =====");

        for(String itemName: inventory.keySet()){
            System.out.println(itemName + ": " + inventory.get(itemName));
        }

        System.out.println("Failed sales: " + failedSales);
    }   
}
