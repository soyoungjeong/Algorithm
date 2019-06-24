package basic;

import java.util.Scanner;

public class Pre {
    public static void swap(int[] p, int a, int b){
        int temp = p[a];
        p[a] = p[b];
        p[b] = temp;
    }
    public static int next_permutation(int[] p,int n){
        int i = n-1;
        while(i > 0 && p[i-1] <= p[i]) i -= 1;
        if(i <= 0) return -1;
        int j = n-1;
        while(p[i-1] <= p[j]) j -= 1;
        swap(p, i-1, j);
        j = n - 1;
        if(i < j){
            swap(p, i, j);
            i += 1; j -= 1;
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] p = new int[n];

        for(int i = 0; i < n; i++){
            p[i] = scan.nextInt();
        }

        int a = next_permutation(p, n);
        if(a == -1) {
            System.out.println(-1);
        }
        else{
            for(int i = 0; i < n; i++){
                System.out.print(p[i] + " ");
            }
        }
    }
}
