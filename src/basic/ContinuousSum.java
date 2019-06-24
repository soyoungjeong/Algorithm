package basic;

import java.util.Arrays;
import java.util.Scanner;

public class ContinuousSum {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = scan.nextInt();
        }

        for(int i = 0; i < n; i++){
            d[i] = a[i];
            if(i == 0) continue;
            if(d[i] < d[i-1] + a[i]){
                d[i] = d[i-1] + a[i];
            }
        }

        Arrays.sort(d);
        System.out.println(d[n-1]);
    }
}
