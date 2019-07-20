package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeContinueSum {
    public static int ans = 0;

    static boolean isPrime(int num){
        if(num==1) return false;
        for(int i=2; i*i<=num; i++){
            if(num%i==0) return false;
        }
        return true;
    }

    static void sum(ArrayList<Integer> list, int start, int n){
        if(start >= list.size()) return ;
        int sum = 0;
        for(int i=start; i<list.size(); i++){
            sum += list.get(i);
            if(sum==n){
                ans += 1;
                break;
            }
            if(sum>n){
                break;
            }
        }
        sum(list, start+1, n);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=2; i<=n; i++){
            if(isPrime(i)){
                list.add(i);
            }
        }

        sum(list, 0, n);
        System.out.println(ans);

    }
}
