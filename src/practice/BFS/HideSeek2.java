package practice.BFS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//12851번
public class HideSeek2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;

        if(n == k) count += 1;
        int[] check = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        check[n] += 1;

        while(!q.isEmpty()){
            int x = q.remove();

            ArrayList<Integer> tempQ = new ArrayList<>();
            tempQ.add(x-1); tempQ.add(x+1); tempQ.add(2*x);

            for(int y : tempQ){
                if(y >= 0 && y < check.length){
                    if(check[y] == 0){
                        check[y] = check[x] + 1;
                        q.add(y);
                        if(y==k) count += 1;
                    }
                    else if(check[y] == check[x] + 1){
                        q.add(y);
                        if(y==k) count += 1;
                    }
                }
            }
        }

        System.out.println(check[k]-1);
        System.out.println(count);
    }
}
