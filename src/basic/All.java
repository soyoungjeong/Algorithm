package basic;

import java.util.Scanner;

public class All {
    static void swap(int[] p, int a, int b){
        int temp = p[a];
        p[a] = p[b];
        p[b] = temp;
    }
    static boolean next_permutation(int[] p, int n){
        int i = n-1;
        while(i > 0 && p[i-1] >= p[i]) i -= 1;
        if(i <= 0) return false;
        int j = n-1;
        while(p[i-1] >= p[j]) j -= 1;
        swap(p, i-1, j);
        j = n - 1;
        while(i < j){
            swap(p, i, j);
            i += 1; j -= 1;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] p = new int[n];
        for(int i = 0; i < n; i++){
            p[i] = i+1;
        }

         do{
            for(int k = 0; k < n; k++){
                System.out.print(p[k] + " ");
            }
             System.out.println();
        }while(next_permutation(p, n));
    }
}
