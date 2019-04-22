import java.util.Scanner;

public class Wine {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] w = new int[n];
        int[][] d = new int[3][n];

        for(int i = 0; i < n; i++){
            w[i] = scan.nextInt();
        }

        d[0][0] = 0; d[1][0] = w[0]; d[2][0] = 0;
        for(int i = 1; i < n; i++){
            d[0][i] = Math.max(d[0][i-1], Math.max(d[1][i-1], d[2][i-1]));
            d[1][i] = d[0][i-1] + w[i];
            d[2][i] = d[1][i-1] + w[i];
        }

        int ans = 0;
        ans = Math.max(d[0][n-1], Math.max(d[1][n-1], d[2][n-1]));
        System.out.println(ans);
    }
}
