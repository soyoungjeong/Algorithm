package basic;

import java.util.Scanner;

public class SumSeq {
    public static int count = 0;
    static void go(int[] a, int sum, int s, int index, int c){
        if(index == a.length){
            if(sum == s && c > 0){
                count += 1;
                return ;
            }
            else{
                return ;
            }
        }
        go(a, sum + a[index], s, index + 1, c+1);
        go(a, sum, s, index + 1,c);
        return ;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int s = scan.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = scan.nextInt();
        }
        go(a, 0, s, 0, 0);
        System.out.println(count);
    }
}
