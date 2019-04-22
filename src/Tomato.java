import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pair4{
    int x, y;
    Pair4(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Tomato {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[n][m];
        Queue<Pair4> q = new LinkedList<>();
        int max = 0;
        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[i][j] = scan.nextInt();
            }
        }

        for(int i = 0; i <n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 1){
                    Pair4 pair = new Pair4(i, j);
                    q.add(pair);
                }
            }
        }

        while(!q.isEmpty()){
            int x = q.element().x;
            int y = q.element().y;
            q.poll();
            for(int i = 0; i < 4; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];
                if (0 <= X && X < n && 0 <= Y && Y < m) {
                    if (a[X][Y] == 0) {
                        Pair4 newPair = new Pair4(X, Y);
                        q.add(newPair);
                        a[X][Y] = a[x][y] + 1;
                    }
                }
            }
        }

        for(int i = 0; i <n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 0) {
                    ans = 1;
                    break;
                } else {
                    max = Math.max(max, a[i][j]);
                }
            }
        }
        if(ans == 1) System.out.println(-1);
        else System.out.println(max-1);
    }
}
