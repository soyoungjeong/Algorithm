package basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair7 {
    int x, y;
    Pair7(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Escape {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static boolean[][] check;
    public static int[][] water;
    public static String[][] map;
    public static Queue<Pair7> q;
    public static int r;
    public static int c;
    public static int result;
    public static boolean canMove;
    static boolean range(int x, int y){
        if(0 > x || x >= r || 0 > y || y >= c) return false;
        else return true;
    }
    static void move(int a, int b){
        result = 1;
        q.add(new Pair7(a, b));
        check[a][b] = true;

        loop : while(!q.isEmpty()){
            int size = q.size();

            for(int s = 0; s < size; s++){
                Pair7 newPair = q.poll();

                for(int i = 0; i < 4; i++){
                    int X = newPair.x + dx[i];
                    int Y = newPair.y + dy[i];

                    if(!range(X,Y)) continue ;
                    if(!check[X][Y]){
                        if(map[X][Y].equals(".") && (water[X][Y] > result || water[X][Y] == 0)){
                            q.add(new Pair7(X, Y));
                            check[X][Y] = true;
                        }
                        if(map[X][Y].equals("D")){
                            check[X][Y] = true;
                            canMove = true;
                            break loop;
                        }
                    }
                }
            }
            result += 1;
        }
    }
    static void water(){
        int count = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int s = 0; s < size; s++){
                Pair7 newPair = q.poll();

                for(int i = 0; i < 4; i++){
                    int X = newPair.x + dx[i];
                    int Y = newPair.y + dy[i];

                    if(0 <= X && X < r && 0 <= Y && Y < c){
                        if(!check[X][Y]){
                            if(map[X][Y].equals(".")){
                                q.add(new Pair7(X, Y));
                                check[X][Y] = true;
                                water[X][Y] = count;
                            }
                        }
                    }
                }
            }
            count += 1;
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        r = scan.nextInt();
        c = scan.nextInt();
        map = new String[r][c];
        check = new boolean[r][c];
        water = new int[r][c];
        q = new LinkedList<>();

        for(int i = 0; i < r; i++){
            String temp = scan.next();
            for(int j = 0; j < c; j++){
                map[i][j] = String.valueOf(temp.charAt(j));
            }
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j].equals("*")){
                    q.add(new Pair7(i,j));
                    check[i][j] = true;
                }
            }
        }
        water();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(water[i][j] + " ");
            }
            System.out.println();
        }
        check = new boolean[r][c];
        int a = 0, b = 0;
        for(int n = 0; n < r; n++){
            for(int m = 0; m < c; m++){
                if(map[n][m].equals("S")){
                    a = n;
                    b = m;
                }
            }
        }
        move(a, b);
        System.out.println(canMove ? result : "KAKTUS");
    }
}
