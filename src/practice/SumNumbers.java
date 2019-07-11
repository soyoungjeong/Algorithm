package practice;


import java.util.Scanner;

//2003번
//내가 처음 푼 풀이
public class SumNumbers {
    public static int[] a;
    public static int ans = 0;
    static void sum(int start, int m){
        int sum = 0;
        if(start == a.length) return ;
        for(int i=start; i<a.length; i++){
            sum+=a[i];
            if(sum==m){
                ans += 1;
                break;
            }
            if(sum>m){
                break;
            }
        }
        sum(start+1, m);
        return ;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        sum(0, m);
        System.out.println(ans);

    }
}
