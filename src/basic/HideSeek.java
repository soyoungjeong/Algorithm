package basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideSeek {
    public static int[] d;
    static void bfs(int index, int k){
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        d[index] = 0;

        while(d[k] == 0 && !q.isEmpty()) {
            int i = q.poll();

            if (i + 1 < d.length) {
                if(d[i + 1] == 0) {
                    q.add(i + 1);
                    d[i + 1] = d[i] + 1;
                }
            }
            if (i - 1 >= 0) {
                if(d[i - 1] == 0) {
                    q.add(i - 1);
                    d[i - 1] = d[i] + 1;
                }
            }
            if (i * 2 < d.length) {
                if(d[i * 2] == 0) {
                    q.add(i * 2);
                    d[i * 2] = d[i] + 1;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        d = new int[200002];
        if(n == k ){
            System.out.println(0);
        }
        else{
            bfs(n, k);
            System.out.println(d[k]);
        }
    }
}
