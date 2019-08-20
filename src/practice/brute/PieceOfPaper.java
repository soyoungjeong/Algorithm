package practice.brute;

import java.util.Scanner;

public class PieceOfPaper {
    public static int[][] paper;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                paper[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        for(int s=0; s<(1<<n*m); s++){
            int sum = 0;

            //가로
            for(int i=0; i<n; i++){
                int cnt = 0;
                for(int j=0; j<m; j++){
                    int k = i*m+j;
                    if((s&(1<<k)) == 0){
                        cnt = cnt * 10 + paper[i][j];
                    }
                    else{
                        sum += cnt;
                        cnt = 0;
                    }
                }
                sum += cnt;
            }


            //세로
            for(int j=0; j<m; j++){
                int cnt = 0;
                for(int i=0; i<n; i++){
                    int k = i*m+j;
                    if((s&(1<<k)) != 0){
                        cnt = cnt * 10 + paper[i][j];
                    }
                    else{
                        sum += cnt;
                        cnt = 0;
                    }
                }
                sum += cnt;
            }

            ans = Math.max(sum, ans);
        }

        System.out.println(ans);

    }
}
