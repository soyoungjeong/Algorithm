package practice;

import java.util.Scanner;

public class NumWrite {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        int k = (int)(Math.log10(n) + 1);
        for(int i=0; i<k-1; i++){
            count += 9*Math.pow(10, i)*(i+1);
        }

        int p = (int)Math.pow(10, k-1);
         count += (n-p+1)*k;

        System.out.println(count);
    }
}
