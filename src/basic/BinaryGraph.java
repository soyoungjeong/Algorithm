package basic;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryGraph {
    public static ArrayList<Integer>[] a;
    public static int[] color;
    static boolean dfs(int x, int c){
        color[x] = c;
        for(int y : a[x]){
            if(color[y] == 0){
                dfs(y, 3-c);
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();

        while(k-- > 0) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int result = 0;

            a = (ArrayList<Integer>[]) new ArrayList[n+1];
            color = new int[n+1];
            for(int i = 0; i <= n; i++){
                a[i] = new ArrayList<>();
            }
            for(int i = 1; i <= m; i++){
                int p = scan.nextInt();
                int q = scan.nextInt();

                a[p].add(q);
                a[q].add(p);
            }
            for(int j = 1; j <= n; j++){
                if(color[j] == 0){
                    dfs(j, 1);
                }
            }
            for(int i = 1; i <= n; i++){
                for(int j : a[i]){
                    if(color[i] == color[j]){
                        result = 1;
                        break;
                    }
                }
            }

            if(result == 1) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
