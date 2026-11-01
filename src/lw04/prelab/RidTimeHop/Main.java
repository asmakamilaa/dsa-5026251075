package lw04.prelab.RidTimeHop;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{        //throws Exception = izin agar tidak error kalau file tidak ditemukan
        Scanner input = new Scanner(Main.class.getResourceAsStream("/lw04/prelab/branches.txt"));

        //=====Baca data dari txt=====
        int n = input.nextInt();        //line 1: jumlah branch (ex.7)
        int[] branches = new int[n];    //buat array kosong seukuran n untuk nilai stabilitas

        for (int i=0; i<n; i++){
            branches[i] = input.nextInt();  //baca 1 angka dari line 2, simpan di indeks ke-i
        }

        int m = input.nextInt();        //line 3: jumlah targets (ex.3)
        int[] targets = new int[m];     //buat array kosong seukuran m untuk target pencarian

        for (int i=0; i<m; i++){
            targets[i] = input.nextInt();   //baca 1 angka dari line 4, simpan di indeks ke-i
        }

        input.close();

        //=====Sorting=====
        insertionSort(branches, 3);     //urutkan branches, berhenti setelah 3 pass (sesuai soal)

        //=====Cetak Array after 3 pass=====
        for (int i=0; i<n; i++){
            if(i>0){                    //Kalau ini bukan angka pertama...
                System.out.print(" ");  //...cetak spasi dulu --> spasi hanya ada di antara angka. No space in the last number
            }
            System.out.print(branches[i]);
        }
        System.out.println();   //new line

        //=====Search every Targets=====
        for (int i=0; i<m; i++){
            int index = linearSearch(branches, targets[i]);     //cari targetr[i] di dalam branches (yg sudah di-sort)
                                                                //hasilnya (indeks atau -1) ditampung di variabel index
            
            if(index != -1){    //"Kalau ga ada/ketemu -1..."
                System.out.println(targets[i] + ": FOUND at index " + index);
            } else{
                System.out.println(targets[i] + ": NOT FOUND");
            }
        }
    }

    static void insertionSort(int[] a, int passes){        

        for (int i=1; i <= passes; i++) {
            int key = a[i];
            int j = i-1;        //Angka di sebelah kiri i

            while(j >= 0 && a[j] < key){
                a[j+1] = a[j];
                j--;
            }

            a[j+1] = key;
        }
    }

    static int linearSearch(int[] a, int target){       //target: angka yang dicari
        for(int i = 0; i<a.length; i++){
            if(a[i] == target){
                return i;
            }
        }
        return -1;      //loop habis tanpa ketemu; kirim -1 sebagai tanda "NOT FOUND"
    }
}
