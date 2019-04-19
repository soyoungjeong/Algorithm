import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pair2 {
        int x, y;
        Pair2(int x, int y){
            this.x = x;
            this.y = y;
        }
}
public class Islands {
    public static int[][] a;
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {-1, 1, -1, 0, 0, 1, -1, 1};
    static void bfs(int x, int y, int w, int h){
        Queue<Pair2> q = new LinkedList<>();
        Pair2 pair = new Pair2(x, y);
        q.add(pair);
        a[x][y] = 0;
        while(!q.isEmpty()) {
            x = q.element().x;
            y = q.element().y;
            q.poll();

            for (int i = 0; i < 8; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];
                if (0 <= X && X < w && 0 <= Y && Y < h) {
                    if (a[X][Y] == 1) {
                        Pair2 newPair = new Pair2(X, Y);
                        q.add(newPair);
                        a[X][Y] = 0;
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int w;
        int h;

        while(true){
            int result = 0;
            h = scan.nextInt();
            w = scan.nextInt();
            if(w == 0 && h == 0){
                break;
            }
            a = new int[w][h];

            for(int i = 0; i < w; i++){
                for(int j = 0; j < h; j++){
                    a[i][j] = scan.nextInt();
                }
            }

            for(int i = 0; i < w; i++){
                for(int j = 0; j < h; j++){
                    if(a[i][j] == 1) {
                        bfs(i, j, w, h);
                        result += 1;
                    }
                }
            }

            System.out.println(result);

        }
    }
}
