package practice.dynamic;

import java.util.Arrays;
import java.util.Scanner;


////2294번
public class Coin2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coin = new int[n];
        long[] d = new long[k+1];

        for(int i=0; i<n; i++){
            coin[i] = sc.nextInt();
        }
        Arrays.sort(coin);
        Arrays.fill(d, 12345678);
        d[0] = 1;
        for(int i=1; i<=k; i++){
            for(int j=0; j<n; j++){
                if(i-coin[j]>0){
                    if(coin[j] != 1 && i%coin[j] == 0){
                        d[i] = Math.min(i/coin[j], d[i-coin[j]] + 1);
                    }else{
                        d[i] = Math.min(d[i], d[i-coin[j]] + 1);
                    }
                }else{
                    if(coin[j] != 1 && i%coin[j] == 0) {
                        d[i] = Math.min(d[i], i/coin[j]);
                    }
                }

            }
        }

        if(d[k] == 12345678) System.out.println(-1);
        else System.out.println(d[k]);
    }
}
