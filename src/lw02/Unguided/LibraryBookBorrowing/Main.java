//Module 02: Linked List, Stack, Queue
//Unguided Case: Library Book Borrowing

package lw02.Unguided.LibraryBookBorrowing;

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(Main.class.getResourceAsStream("/lw02/Unguided/borrowing.txt"));

        LinkedList<String[]> borrowingRequests = new LinkedList<>();
        LinkedList<String[]> bookRecords = new LinkedList<>();
        LinkedList<String[]> memberRecords = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failedRequests = new Stack<>();
        LinkedList<String[]> successfulRequests = new LinkedList<>();

        final int MAX_BORROW = 2;

        //Menyimpan data buku dan stok awal
        bookRecords.add(new String[]{"Kalkulus", "2"});
        bookRecords.add(new String[]{"Fisika", "1"});
        bookRecords.add(new String[]{"Statistika", "2"});

        //Membaca data awal
        while(input.hasNext()){
             String[] data = new String[2];

             data[0] = input.next();
             data[1] = input.next();

             borrowingRequests.add(data);
        }

        input.close();

        //Membuat daftar member
        for(String[] request : borrowingRequests){
            String name = request[0];
            String[] member = null;

            for(String[] data : memberRecords){
                if(data[0].equals(name)){
                    member = data;
                    break;
                }
            }

            if(member == null){
                member = new String[]{name, "0"};
                memberRecords.add(member);
            }
        }

        //Memindahkan request dari LinkedList ke Queue
        while(!borrowingRequests.isEmpty()){
            String[] request = borrowingRequests.removeFirst();

            queue.add(request);

        }

        //Memproses request dari Queue
        while (!queue.isEmpty()) {
            String[] request = queue.poll();

            String name = request[0];
            String bookTitle = request[1];

            String[] book = null;
            String[] member = null;

            //Searching for books
            for(String[] data : bookRecords){
                if(data[0].equals(bookTitle)){
                    book = data;
                    break;
                }
            }

            //Searc member
            for(String[] data : memberRecords){
                if(data[0].equals(name)){
                    member = data;
                    break;
                }
            }

            int stock = Integer.parseInt(book[1]);
            int borrowed = Integer.parseInt(member[1]);

            //Mengecek apakah req berhasil
            if(stock>0 && borrowed < MAX_BORROW){
                stock--;
                borrowed++;

                book[1] = String.valueOf(stock);
                member[1] = String.valueOf(borrowed);

                successfulRequests.add(request);
            } else{
                failedRequests.push(request);
            }
        }

        //Output
        System.out.println("\n === Successfully Processed Requests ===");

        for(String[] request : successfulRequests){
            System.out.println(request[0] + " : " + request[1]);
        }

        System.out.println("\n === Remaining Book Stock ===");

        for(String[] book : bookRecords){
            System.out.println(book[0] + " : " + book[1]);
        }

        System.out.println("\n === Failed Requests ===");

        while(!failedRequests.isEmpty()){
            String[] request  = failedRequests.pop();
            System.out.println(request[0] + " " + request[1]);
        }

    } 
    
}
