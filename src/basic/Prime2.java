package basic;

import java.util.Scanner;

public class Prime2 {
    static boolean isPrime(int n){
        if(n == 1) return false;
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();

        for(int i = m; i <= n; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }
}
