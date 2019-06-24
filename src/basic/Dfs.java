package basic;

import java.util.*;

public class Dfs {
    public static boolean[] check;
    public static ArrayList<Integer>[] a;
    public static Queue<Integer> q = new LinkedList<>();
    static void dfs(int v){
        if(check[v]){
            return ;
        }
        check[v] = true;
        System.out.print(v + " ");
        for(int y : a[v]) {
            if (check[y] == false){
                dfs(y);
            }
        }
    }
    static void bfs(int v){
        q.add(v);
        check[v] = true;
        while(!q.isEmpty()){
            int x = q.remove();
            System.out.print(x + " ");
            for(int y : a[x]){
                if(check[y] == false){
                    check[y] = true;
                    q.add(y);
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int v = scan.nextInt();

         a = (ArrayList<Integer>[]) new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            a[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < m; i++){
            int p = scan.nextInt();
            int q = scan.nextInt();
            a[p].add(q);
            a[q].add(p);
        }
        for(int i = 1; i <= n; i++){
            Collections.sort(a[i]);
        }
        check = new boolean[n+1];
        dfs(v);
        System.out.println();
        for(int i = 0; i <= n; i++){
            check[i] = false;
        }
        bfs(v);
    }
}
