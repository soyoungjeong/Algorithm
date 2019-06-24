package basic;

import java.util.ArrayDeque;
import java.util.Scanner;
class Pair5 {
    int x, y;
    Pair5(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Algospot {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int[][] a;
    public static int[][] d;
    public static boolean[][] c;
    public static int n, m;
    public static void bfs(int x, int y){
        ArrayDeque<Pair5> q = new ArrayDeque<>();
        Pair5 pair = new Pair5(x,y);
        q.addFirst(pair);
        c[x][y] = true;

        while(!q.isEmpty()){
            x = q.element().x;
            y = q.element().y;
            q.poll();

            for(int i = 0; i < 4; i++){
                int X = x + dx[i];
                int Y = y + dy[i];
                Pair5 newPair = new Pair5(X, Y);

                if(0 <= X && X < n && 0 <= Y && Y < m){
                    if(!c[X][Y]){
                        if(a[X][Y] == 0){
                            q.addFirst(newPair);
                            c[X][Y] = true;
                            d[X][Y] = d[x][y];
                        }
                        else{
                            q.addLast(newPair);
                            c[X][Y] = true;
                            d[X][Y] = d[x][y] + 1;
                        }
                    }
                }
            }
        }

    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        m = scan.nextInt();
        n = scan.nextInt();
        a = new int[n][m];
        c = new boolean[n][m];
        d = new int[n][m];

        for(int i = 0; i < n; i++){
            String temp = scan.next();
            for(int j = 0; j < m; j++){
                a[i][j] = temp.charAt(j) - 48;
            }
        }
        bfs(0,0);

        System.out.println(d[n-1][m-1]);
    }
}
