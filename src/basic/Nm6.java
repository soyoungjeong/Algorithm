package basic;

import java.util.Arrays;
import java.util.Scanner;

public class Nm6 {
    static int[] p;
    static boolean[] v;
    static void go(int[] num, int index, int n, int m, int cur){
        if(cur == m){
            for(int i = 0; i < m; i++){
                System.out.print(p[i] + " ");
            }
            System.out.println();
            return ;
        }
        if(index >= n) return ;
        else p[cur] = num[index];
        go(num, index + 1, n, m, cur + 1);
        go(num, index + 1, n, m, cur);
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] num = new int[n];
        p = new int[10];
        v = new boolean[10001];
        for(int i = 0; i < n; i++){
            num[i] = scan.nextInt();
        }
        Arrays.sort(num);
        go(num, 0, n, m, 0);
    }
}
