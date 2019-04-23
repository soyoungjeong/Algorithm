import java.util.Scanner;

public class SumResolution {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        long[][] d = new long[k+1][n+1];
        long mod = 1000000000L;

        for(int i = 0; i <= n; i++){
            d[1][i] = 1;
        }
        for(int i = 0; i <= k; i++){
            d[i][0] = 1;
        }
        /*for(int i = 0; i <= n; i++){
            d[2][i] = i + 1;
        }
        for(int i = 3; i <= k; i++){
            for(int j = 0; j <= n; j++){
                for(int l = 0; l <= j; l++){
                    d[i][j] += d[i-1][j-l];
                    d[i][j] %= mod;
                }
            }
        }*/

        for(int i = 1; i <= k; i++){
            for(int j = 1; j <= n; j++){
                d[i][j] = d[i][j-1] + d[i-1][j];
                d[i][j] %= mod;
            }
        }
        System.out.println(d[k][n]%mod);
    }
}
