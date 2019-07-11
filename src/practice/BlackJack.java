package practice;

import java.util.*;

public class BlackJack {
    public static int[] num ;
    public static int m;
    public static int max = 0;
    static void go(int index, int cnt, int sum){
        if(sum > m) return ;
        if(cnt >= 3){
            if(sum <= m){
                max = Math.max(max, sum);
                return ;
            }
        }
        if(index >= num.length) return ;
        go(index+1, cnt+1, sum+num[index]);
        go(index+1, cnt, sum);
        return ;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        num = new int[n];
        for(int i=0; i<n; i++){
            num[i] = sc.nextInt();
        }
        go(0,0,0);
        System.out.println(max);
    }
}
