package jmbook;

import java.util.*;

public class JLis {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();

        while(c-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];

            Set<Integer> map = new TreeSet<>();

            for(int i=0; i<n; i++){
                arr1[i] = sc.nextInt();
                map.add(arr1[i]);
            }
            for(int i=0; i<m; i++){
                arr2[i] = sc.nextInt();
                map.add(arr2[i]);
            }

            int[] jlis = new int[map.size()];
            Arrays.fill(jlis, 1);
            Integer[] arr = map.toArray(new Integer[map.size()]);

            for(int i=0; i<map.size(); i++){
                for(int j=0; j<i; j++){
                    if(arr[i] > arr[j]){
                        jlis[i] = Math.max(jlis[i], jlis[j] + 1);
                    }
                }
            }

            int max = 0;
            for(int i=0; i<jlis.length; i++){
                max = Math.max(jlis[i], max);
            }

            System.out.println(max);
        }
    }
}
