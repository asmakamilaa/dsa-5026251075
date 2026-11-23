package lw06.unguided.LibraryBookCatalog;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("/lw06/unguided/treenumbers.txt"));

        // Write your main code here

        String line = read.nextLine();
        String[] numbers = line.split(" ");

        BinarySearchTree bst = new BinarySearchTree();

        for(int i=0; i<numbers.length; i++){
            int value = Integer.parseInt(numbers[i]);
            bst.insert(value);
        }

        int target = read.nextInt();

        System.out.print("Preorder : ");
        bst.preOrder();

        System.out.print("Inorder : ");
        bst.inOrder();

        System.out.print("Postorder : ");
        bst.postOrder();

        System.out.println("Search " + target + " : " + bst.search(target));
        System.out.println("Minimum : " + bst.findMin());
        System.out.println("Maximum : " + bst.findMax());

        read.close();
    }
}
