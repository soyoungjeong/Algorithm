import java.util.Scanner;

public class Abcde {
    public static boolean[] v;
    public static int cnt = 0;
    static void go(int[][] b, int i, int n, int count){
        if(count >= 4) {
            cnt = count;
            return ;
        }
        for(int j = 0; j < n; j++) {
            if (b[i][j] == 1) {
                b[i][j] = 0;
                for(int k = 0; k < n; k++) {
                    b[k][i] = 0;
                }
                go(b, j, n, count+1);
            }
        }
        return ;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] a = new int[m][2];
        int[][] b = new int[n][n];
        v = new boolean[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < 2; j++){
                a[i][j] = scan.nextInt();
            }
            b[a[i][0]][a[i][1]] = 1;
            b[a[i][1]][a[i][0]] = 1;
        }

        for(int i = 0; i < n; i++){
            go(b, i, n, 0);
            if(cnt >= 4){
                System.out.println("1");
                break;
            }
        }
        if(cnt == 0) System.out.println("0");
    }
}
