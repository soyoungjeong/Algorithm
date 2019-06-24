package basic;

import java.util.Scanner;

public class Sum2 {
    static int go(int count, int sum, int n){
        if(sum > n) return 0;
        if(sum == n) return 1;
        int now = 0;
        for(int i = 1; i <= 3; i++) {
            now += go(count + 1, sum + i, n);
        }
        return now;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int n;
        int count;

        for(int i = 0; i < t; i++){
            n = scan.nextInt();
            count = go(0, 0, n);
            System.out.println(count);
        }
    }
}
