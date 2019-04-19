import java.util.*;

class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Number {
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    public static int[][] a;
    static int bfs(int x, int y, int count, int n){
        Queue<Pair> q = new LinkedList<>();
        Pair pair = new Pair(x, y);
        q.add(pair);
        a[x][y] = 0;
        while(!q.isEmpty()){
            x = q.element().x;
            y = q.element().y;
            q.poll();

            for(int k = 0; k < 4; k++){
                int X = x + dx[k];
                int Y = y + dy[k];

                if(0 <= X && X < n && 0 <= Y && Y < n){
                    if(a[X][Y] == 1){
                        Pair newPair = new Pair(X, Y);
                        q.add(newPair);
                        a[X][Y] = 0;
                        count += 1;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        a = new int[n][n];

        for(int i = 0; i < n; i++){
            String temp = scan.next();
            String[] tempArray = temp.split("");
            for(int j = 0; j < n; j++) {
                String number = tempArray[j];
                a[i][j] = Integer.parseInt(number);
            }
        }

        int result = 0;
        ArrayList b = new ArrayList();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(a[i][j] == 1){
                    result += 1;
                    b.add(bfs(i, j, 1, n));
                }
            }
        }
        System.out.println(result);
        Collections.sort(b);
        for(int i = 0; i < b.size(); i++){
            System.out.println(b.get(i));
        }
    }
}
