import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pair6 {
    int x, y, d;
    Pair6(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
public class BreakingWalls {
    public static int[][] a;
    public static boolean[][][] c;
    public static int n, m;
    public static int count;
    public static boolean canMove;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        a = new int[n][m];
        c = new boolean[n][m][2];

        for(int i = 0; i < n; i++){
            String temp = scan.next();
            for(int j = 0; j < m; j++){
                a[i][j] = temp.charAt(j) - 48;
            }
        }

        Queue<Pair6> q = new LinkedList<>();
        c[0][0][1] = true;
        q.add(new Pair6(0, 0, 1));

        loop : while(!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                Pair6 newPair = q.poll();
                if (newPair.x == n-1 && newPair.y == m-1) { //도착
                    count++;
                    canMove = true;
                    break loop;
                }
                for (int i = 0; i < 4; i++) {
                    int X = newPair.x + dx[i];
                    int Y = newPair.y + dy[i];
                    if (0 <= X && X < n && 0 <= Y && Y < m) {
                        if (a[X][Y] == 1) {
                            if (newPair.d > 0 && !c[X][Y][0]) {
                                c[X][Y][0] = true;
                                q.add(new Pair6(X, Y, 0));
                            }
                        }
                        else {
                            if (!c[X][Y][newPair.d]){
                                c[X][Y][newPair.d] = true;
                                q.add(new Pair6(X, Y, newPair.d));
                            }
                        }
                    }
                }
            }
            count++;
        }
        System.out.println(canMove ? count : -1);
    }
}