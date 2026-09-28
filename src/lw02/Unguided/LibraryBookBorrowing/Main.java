package lw02.Unguided.LibraryBookBorrowing;

import java.util.*;

public class Main{
    publis static void main(String[] args){
        Scanner input = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));
        LinkedList<String[]> borrowingRequests = new LinkedList<>();
        LinkedList<String[]> bookRecords = new LinkedList<>();
        LinkedList<String[]> memberRecords = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failedTransactions = new Stack<>();

        while(input.hasNext()){
             String[] borrowingRequests = new String[2];
             borrowingRequests[0] = input.next();
             borrowingRequests[1] = input.next();
             borrowingRequests.add(borrowingRequests);
        }

        input.close();

        queue.addAll(borrowingRequests);

        while(!queue.isEmpty()){
            String[] borrowingRequests = queue.poll();    //Poll=ambil elemen terdepan dari sebuah queu
            String name = borrowingRequests[0];
            String title = borrowingRequests[0];

            String[] memberRecords = null;
            for(String[] data:memberRecords){
                if(data[0].equals(name)){
                    memberRecords = data;
                    break;
                }
            }
            //kalau blm pernah
            if(memberRecords == null){
                memberRecords = new String[]{name, "0"};
                memberRecords.add(memberRecords);
            }

            String[] bookRecords = queue.poll();   //Poll=ambil elemen terdepan dari sebuah queu
            String Kalkulus = 2;
            String Fisika = 1;
            String Statistika = 1;

            if(bookRecords[].equals(title) && memberRecords <= 2)){
            }
        }

        System.out.println(\n "=== Successfully Processed Requests ===");

        for(String[] memberRecords : memberRecords){
            System.out.println(borrowingRequests[0] + " : " + borrowingRequests[1]);
        }

        System.out.println(\n "=== Remaining Book Stock ===");

        for(String[] bookRecords : bookRecords){
            System.out.println("Kalkulus : " + );
            System.out.println("Fisika : " + );
            System.out.println("Statistika : " + );
        }

        System.out.println(\n  "=== Failed Requests ===");

        while(!failedTransactions.isEmpty()){
            String[] borrowingRequests = failed.pop();
            System.out.println(borrowingRequests[0] + " " + borrowingRequests[1]);
        }

    } 
    
}
