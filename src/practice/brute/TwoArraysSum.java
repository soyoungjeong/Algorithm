package practice.brute;

import java.lang.reflect.Array;
import java.util.*;


//2143번
public class TwoArraysSum {
    static ArrayList<Integer> sum(int[] arr, ArrayList<Integer> list){
        for(int i=0; i<arr.length; i++){
            int sum = 0;
            for(int j=i; j<arr.length; j++){
                sum += arr[j];
                list.add(sum);
            }
        }
        return list;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i=0; i<m; i++){
            b[i] = sc.nextInt();
        }

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();

        first = sum(a, first);
        second = sum(b, second);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : second){
            if(map.containsKey(x)){
                int temp = map.get(x);
                map.put(x, temp+1);
            }else {
                map.put(x, 1);
            }

        }
        long ans = 0;
        for(int num : first){
            if(map.containsKey(t-num)){
                ans += map.get(t-num);
            }
        }
        System.out.println(ans);
    }
}
