package basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pair3{
    int x, y;
    Pair3(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Maze {
    public static int[][] a;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static void bfs(int x, int y, int n, int m){
        Queue<Pair3> q = new LinkedList<>();
        Pair3 pair = new Pair3(x, y);
        q.add(pair);
        while(!q.isEmpty()) {
            x = q.element().x;
            y = q.element().y;
            q.poll();
            for (int i = 0; i < 4; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];

                if (0 <= X && X < n && 0 <= Y && Y < m) {
                    if (a[X][Y] == 1) {
                        Pair3 newPair = new Pair3(X, Y);
                        q.add(newPair);
                        a[X][Y] = a[x][y] + 1;
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        a = new int[n][m];

        for(int i = 0; i < n; i++){
            String temp = scan.next();
            for(int j = 0; j < m; j++){
                a[i][j] = temp.charAt(j) - 48;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 1){
                    bfs(0, 0, n, m);
                }
            }
        }
        System.out.println(a[n-1][m-1]);
    }
}
