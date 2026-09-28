// package src.lw02.Prelab.BankTransactionProcessing;

// import java.util.LinkedList;
// import java.util.Queue;         //(Antrian) First In First Out (FIFO)
// import java.util.Stack;         //(Tumpukan) Last In First Out
// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         LinkedList<String[]> transactions = new LinkedList<>();
//         LinkedList<String[]> customers = new LinkedList<>();
//         Stack<String[]> failedTransactions = new Stack<>();

//         Scanner sc = new Scanner(Main.class.getResourceAsStream("/lw02/Prelab/transactions.txt"));

//         while (sc.hasNext()) {
//             String name = sc.next();
//             String type = sc.next();
//             String amount = sc.next();

//             transactions.add(new String[]{name, type, amount});

//             boolean found = false;

//             for (int i = 0; i < customers.size(); i++) {
//                 if (customers.get(i)[0].equals(name)) {
//                     found = true;
//                 }
//             }

//             if (!found) {
//                 customers.add(
//                     new String[]{name, "0"}
//                 );
//             }
//         }

//         sc.close();

//         Queue<String[]> transactionQueue = new LinkedList<>();

//         while (!transactions.isEmpty()) {
//             String[] transaction = transactions.removeFirst();
//             transactionQueue.add(transaction);
//         }

//         while (!transactionQueue.isEmpty()) {
//             String[] transaction = transactionQueue.poll();

//             String name = transaction[0];
//             String type = transaction[1];

//             int amount = Integer.parseInt(transaction[2]);

//             for (int i = 0; i < customers.size(); i++) {
//                 String[] customer = customers.get(i);

//                 if (customer[0].equals(name)) {
//                     int balance = Integer.parseInt(customer[1]);

//                     if (type.equals("DEPOSIT")) {
//                         balance = balance + amount;
//                         customer[1] = String.valueOf(balance);
//                     }

//                     else if (type.equals("WITHDRAW")) {
//                         if (amount > balance) {
//                             failedTransactions.push(transaction);
//                         } else {
//                             balance = balance - amount;
//                             customer[1] = String.valueOf(balance);
//                         }
//                     }
//                 }
//             }
//         }

//         System.out.println("=== Final Balances ===");

//         for (int i = 0; i < customers.size(); i++) {
//             String[] customer = customers.get(i);

//             System.out.println(customer[0] + " : " + customer[1]);
//         }

//         System.out.println(" ");
//         System.out.println("=== Failed Transactions ===");

//         while (!failedTransactions.isEmpty()) {

//             String[] failed = failedTransactions.pop();

//             System.out.println(failed[0] + " " + failed[1] + " " + failed[2]);
//         }
//     }
