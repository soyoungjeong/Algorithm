package basic;

import java.util.Scanner;

public class Nm4 {
    public static int[] p = new int[10];
    static boolean[] v = new boolean[10];
    static void go(int index, int n, int m){
        if(index == m){
            for(int i = 0; i < m; i++){
                System.out.print(p[i] + " ");
            }
            System.out.println();
            return ;
        }
        for(int i = 1; i <= n; i++){
            if(index > 0){
                while(i < p[index-1]) {
                    i++;
                }
            }
            p[index] = i;
            go(index + 1, n, m);

        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        go(0, n, m);
    }
}