package lw02.Prelab.BankTransactionProcessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customers = new LinkedList<>();

        Stack<String[]> failedTransactions = new Stack<>();

        try {
            File file = new File("src/lw02/Prelab/transactions.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] data = line.split(" ");

                String name = data[0];
                String type = data[1];
                String amount = data[2];

                transactions.add(new String[]{name, type, amount});
                boolean found = false;

                for (int i = 0; i < customers.size(); i++) {
                    if (customers.get(i)[0].equals(name)) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    customers.add(new String[]{name, "0"});
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("transactions.txt tidak ditemukan.");
            return;
        }

        Queue<String[]> queue = new LinkedList<>();

        while (!transactions.isEmpty()) {
            queue.add(transactions.removeFirst());
        }
        while (!queue.isEmpty()) {
            String[] transaction = queue.poll();

            String name = transaction[0];
            String type = transaction[1];
            int amount = Integer.parseInt(transaction[2]);

            for (int i = 0; i < customers.size(); i++) {
                String[] customer = customers.get(i);

                if (customer[0].equals(name)) {
                    int balance = Integer.parseInt(customer[1]);
                    if (type.equals("DEPOSIT")) {

                        balance = balance + amount;

                        customer[1] = String.valueOf(balance);
                    } else if (type.equals("WITHDRAW")) {
                            if (amount > balance) {
                                failedTransactions.push(transaction);
                            } else {
                                balance = balance - amount;
                                customer[1] = String.valueOf(balance);
                            }
                        }

                    break;
                }
            }
        }

        System.out.println("=== Final Balances ===");

        for (int i = 0; i < customers.size(); i++) {
            String[] customer = customers.get(i);
            System.out.println(customer[0] + " : " + customer[1]);
        }
        
        System.out.println(" ");
        System.out.println("=== Failed Transactions ===");

        while (!failedTransactions.isEmpty()) {
            String[] failed = failedTransactions.pop();
            System.out.println(failed[0] + " " + failed[1] + " " + failed[2]);
        }
    }
}