package lw06.prelab.StudentScoreManagement;

import java.util.*;

public class Main {
    public static Node insert(Node root, int data) {
        if (root == null) {             //kalau belum ada isinya, rootnya
            return new Node(data);      //masukin data baru
        }

        if (data < root.data) {                     //kalau lebih kecil, masukkan ke area kiri
            root.left = insert(root.left, data);
        } else if (data > root.data) {              //ke area kanan
            root.right = insert(root.right, data);
        }

        return root;    //kalau data==root.data, abaikan (return)
    }


    public static boolean search(Node root, int target) {
        if (root == null) {     //apakah root kosong atau tidak. Kalau kosong kan gabisa jalan
            return false;
        }


        if (target == root.data) {
            return true;
        } else if (target < root.data) {            //nyari lagi kalau belum ketemu
            return search(root.left, target);       //binary tree = always left first then right
        } else {
            return search(root.right, target);
        }
    }


    public static void preorder(Node root) {        //preorder = root-left-right
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }


    public static void inorder(Node root) {         //inorder = left-root-right
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }


    public static void postorder(Node root) {       //postorder = left-right-root
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("/lw06/prelab/treenumbers.txt"));

        // Write your main code here
        String line = sc.nextLine();
        String[] parts = line.split(" ");

        Node root = null;
        
        for (int i=0; i<parts.length; i++){
            int value = Integer.parseInt(parts[i]);
            root = insert(root, value);
        }

        int target = sc.nextInt();

        System.out.print("Preorder : ");
        preorder(root);
        System.out.println();

        System.out.print("Inorder : ");
        inorder(root);
        System.out.println();

        System.out.print("Postorder : ");
        postorder(root);
        System.out.println();

        System.out.println("Search " + target + " : " + search(root, target));

        sc.close();
    }
}

