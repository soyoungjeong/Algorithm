package practice.dynamic;

////11058번

import java.util.Scanner;

public class KriiBoard {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] d = new long[n+1];
        d[0] = 0;
        d[1] = 1;

        for(int i=2; i<=n; i++){
            d[i] = d[i-1] + 1;
            for(int j=3; j<=i; j++){
                d[i] = Math.max(d[i], d[i-j]*(j-1));
            }
        }

        System.out.println(d[n]);
    }
}
