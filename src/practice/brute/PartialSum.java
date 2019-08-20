package practice.brute;

import java.util.Arrays;
import java.util.Scanner;


//1644
public class PartialSum {
    public static int ans = 1000000;
    static void go(int[] arr, int start, int s){
        int sum = 0;
        int cnt = 0;
        if(start >= arr.length) return ;
        for(int i=start; i<arr.length; i++){
            sum += arr[i];
            if(sum >= s){
                cnt = i - start + 1;
                break;
            }
        }
        if(cnt != 0 && cnt < ans) ans = cnt;
        go(arr, start+1, s);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        go(arr, 0, s);
        if(ans == 1000000) System.out.println(0);
        else System.out.println(ans);
    }
}
