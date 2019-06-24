package basic;

import java.util.Scanner;

public class GcdSum {
    static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        else{
            return gcd(b, a%b);
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int n;
        long g;
        int[] num;
        while(t-- >0){
            g = 0;
            n = scan.nextInt();
            num = new int[n];
            for(int i = 0; i < n; i++){
                num[i] = scan.nextInt();
            }

            for(int i = 0; i < n-1; i++){
                for(int j = i+1; j < n; j++){
                    g += gcd(num[i],num[j]);
                }
            }
            System.out.println(g);
        }


    }
}
