package lw04.unguided.RakaCardGame;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(Main.class.getResourceAsStream("/lw04/unguided/cards.txt"));

        int n = input.nextInt();        
        int[] card = new int[n];    

        for (int i=0; i<n; i++){
            card[i] = input.nextInt();  
        }

        int m = input.nextInt();       
        int[] request = new int[m];     

        for (int i=0; i<m; i++){
            request[i] = input.nextInt();   
        }
        
        input.close();

        sortCards(card, 2);
        for (int i = 0; i < n; i++) {
            if(i>0){
                System.out.print(" ");
            }
            System.out.print(card[i]);
        }
        System.out.println();


        for(int i=0; i<m; i++){
            int idx = findCard(card, request[i]);

            if (idx==-1){
                System.out.println(request[i] + ": NOT FOUND");
            } else{
                System.out.println(request[i] + ": FOUND at index " + idx);
            }
        }
    }

    public static void sortCards(int[] a, int passes) {

        for(int i=0; i<=passes-1; i++){
            int smallestIdx = i;

            for(int j=i+1; j<a.length; j++){
                if (a[j] < a[smallestIdx]){
                    smallestIdx = j;
                }
            }

            int tempKey = a[i];
            a[i] = a[smallestIdx];
            a[smallestIdx] = tempKey;
        }
    }

    public static int findCard(int[] a, int target){

        for(int i=0; i<=a.length-1; i++){
            if (a[i] == target){
                return i;
            }
        }
        
        return -1;
    }
}
