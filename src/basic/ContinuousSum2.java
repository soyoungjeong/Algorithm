package basic;

import java.util.Arrays;
import java.util.Scanner;

public class ContinuousSum2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        int[] dm = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scan.nextInt();
        }
        if(n == 1){
            d[n-1] = a[n-1];
            dm[n-1] = d[n-1] - 1;
        }
        for(int i = 0; i < n; i++){
            d[i] = a[i];
            if(i == 0) continue;
            if(d[i] < d[i-1] + a[i]){
                d[i] = d[i-1] + a[i];
            }
            dm[0] = d[0];
            dm[1] = d[1];
        }
        for(int i = 2; i < n; i++){
            dm[i] = Math.max(dm[i-1] + a[i], d[i-2] + a[i]);
        }

        System.out.println();
        Arrays.sort(d);
        Arrays.sort(dm);
        if(d[n-1] > dm[n-1]) System.out.println(d[n-1]);
        else System.out.println(dm[n-1]);
    }
}
