package practice.dynamic;

import java.util.Scanner;

//11048번
public class Move {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] maze = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                maze[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][m];
        dp[0][0] = maze[0][0];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i-1 < 0 && j-1 >= 0){
                    dp[i][j] = maze[i][j] + dp[i][j-1];
                }else if(j-1 < 0 && i-1 >= 0){
                    dp[i][j] = maze[i][j] + dp[i-1][j];
                }else if(j-1 >= 0 && i-1 >= 0){
                    dp[i][j] = maze[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n-1][m-1]);
    }
}
