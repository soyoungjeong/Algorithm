import java.util.ArrayList;
import java.util.Scanner;

public class Connect {
    public static boolean[] check;
    public static ArrayList<Integer>[] a;
    public static int count = 0;
    static void dfs(int x){
        if(check[x] == true){
            return ;
        }
        check[x] = true;
        for(int y : a[x]){
            if(check[y] == false){
                dfs(y);
            }
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        check = new boolean[n+1];
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

        for(int i = 1; i <= n; i++) {
            if(check[i] == false){
                dfs(i);
                count += 1;
            }
        }
        System.out.println(count);
    }
}
