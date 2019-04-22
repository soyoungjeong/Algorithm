import java.util.Scanner;

public class Sticker {
    public static int[][] a;
    public static int[][] d;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-- > 0){
            int n = scan.nextInt();
            a = new int[2][n];
            d = new int[3][n];
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < n; j++){
                    a[i][j] = scan.nextInt();
                }
            }

            d[0][0] = 0;
            d[1][0] = a[0][0];
            d[2][0] = a[1][0];
            for(int i = 1; i < n; i++){
                d[0][i] = Math.max(d[0][i-1], Math.max(d[1][i-1], d[2][i-1]));
                d[1][i] = Math.max(d[0][i-1] + a[0][i], d[2][i-1] + a[0][i]);
                d[2][i] = Math.max(d[0][i-1] + a[1][i], d[1][i-1] + a[1][i]);
            }

            int ans = 0;
            ans = Math.max(Math.max(d[0][n-1], d[1][n-1]), d[2][n-1]);
            System.out.println(ans);
        }
    }
}
