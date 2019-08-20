package practice.bfs;
import java.util.*;


//6087번
class Path{
    int x;
    int y;
    Path(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Laser {
    public static int[][] d;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static void bfs(String[][] map, int h, int w, int x, int y){
        int answer = 0;

        Queue<Path> q = new LinkedList<>();
        q.add(new Path(x, y));
        d[x][y] = 0;

        while(!q.isEmpty()){
            Path p = q.remove();
            int a = p.x;
            int b = p.y;

            for(int i=0; i<4; i++){
                int na = a + dx[i];
                int nb = b + dy[i];
                while(na>=0 && na<h && nb>=0 && nb<w){
                    if(map[na][nb].equals("*")) break;
                    if(d[na][nb] == -1){
                        d[na][nb] = d[a][b] + 1;
                        q.add(new Path(na, nb));
                    }
                    na += dx[i];
                    nb += dy[i];
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        String[][] map = new String[h][w];
        d = new int[h][w];

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                d[i][j] = -1;
            }
        }

        for(int i=0; i<h; i++){
            String str = sc.next();
            for(int j=0; j<w; j++){
                map[i][j] = String.valueOf(str.charAt(j));
            }
        }

        int x1 = -1;
        int y1 = -1;
        int x2 = -1;
        int y2 = -1;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(map[i][j].equals("C")){
                    if(x1==-1){
                        x1 = i;
                        y1 = j;
                    }
                    else{
                        x2 = i;
                        y2 = j;
                    }
                }
            }
        }
        bfs(map, h, w, x1, y1);
        System.out.println(d[x2][y2]-1);
    }
}
