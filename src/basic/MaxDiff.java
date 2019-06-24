package basic;

import java.util.Arrays;
import java.util.Scanner;

public class MaxDiff {
    static int sum(int[] p, int n){
        int result = 0;
        for(int i = 0; i < n - 1; i++){
            int q = p[i] - p[i+1];
            if(q < 0) q = -q;
            result += q;
        }
        //System.out.println(result);
        return result;
    }
    static void swap(int[] p, int i, int j){
        int temp = p[i];
        p[i] = p[j];
        p[j] = temp;
    }
    static boolean next_permutation(int[] p, int n){
        int i = n - 1;
        while(i > 0 && p[i-1] >= p[i]) i-=1;
        if(i <= 0) return false;
        int j = n - 1;
        while(p[i-1] >= p[j]) j-=1;
        swap(p, j, i-1);
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
        int max = 0;
        for(int i = 0; i < n; i++){
            p[i] = scan.nextInt();
        }

        Arrays.sort(p);



        do {
            int result = sum(p, n);
            if(max < result) max = result;
        }while(next_permutation(p, n));

        System.out.println(max);
    }
}
