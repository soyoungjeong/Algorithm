import java.util.Scanner;

public class Nm2 {
    public static int[] p = new int[10];
    static void go(int index, int n, int m, int cur){
        if(cur == m){
            for(int i = 0; i < m; i++){
                System.out.print(p[i] + " ");
            }
            System.out.println();
            return ;
        }
        if(index > n) return ;
        else p[cur] = index;
        go(index + 1, n, m, cur + 1);
        go(index + 1, n ,m, cur);

    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        go(1, n, m, 0);
    }
}
