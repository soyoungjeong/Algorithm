package samsung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position{
    int x;
    int y;
    int dust;
    Position(int x, int y, int dust){
        this.x = x;
        this.y = y;
        this.dust = dust;
    }
}


public class dustBye {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void diffusion(Queue<Position> q, int[][] room){
        while(!q.isEmpty()){
            Position p = q.remove();
            int x = p.x;
            int y = p.y;
            int dust = p.dust;

            int count = 0;
            for(int i=0; i<4; i++){
                int X = x + dx[i];
                int Y = y + dy[i];

                if(X < 0 || X >= room.length || Y < 0 || Y >= room[0].length) continue;;
                if(room[X][Y] == -1) continue;

                room[X][Y] += dust / 5;
                count += 1;
            }
            room[x][y] -= (dust/5)*count;
        }
    }

    static void circulationLeft(int x, int[][] room){
        if(x == 0){
            for(int i=room[0].length-1; i>0; i--){
                room[x][i] = room[x][i-1];
            }
            room[x][1] = 0;
        }else{
            room[x-1][0] = 0;

            for(int i=x-1; i>0; i--){
                room[i][0] = room[i-1][0];
            }
            room[0][0] = room[0][1];

            for(int i=0; i<room[0].length-1; i++){
                room[0][i] = room[0][i+1];
            }
            room[0][room[0].length-1] = room[1][room[0].length-1];

            for(int i=0; i<x; i++){
                room[i][room[0].length-1] = room[i+1][room[0].length-1];
            }
            room[x][room[0].length-1] = room[x+1][room[0].length-1];

            for(int i=room[0].length-1; i>0; i--){
                room[x][i] = room[x][i-1];
            }
            room[x][1] = 0;
        }
    }

    static void circulationRight(int x, int[][] room){
        if(x == room.length){
            for(int i=room[0].length-1; i>0; i--){
                room[x][i] = room[x][i-1];
            }
            room[x][1] = 0;
        }else{
            room[x+1][0] = 0;

            for(int i=x+1; i<room.length-1; i++){
                room[i][0] = room[i+1][0];
            }
            room[room.length-1][0] = room[room.length-1][1];

            for(int i=0; i<room[0].length-1; i++){
                room[room.length-1][i] = room[room.length-1][i+1];
            }
            room[room.length-1][room[0].length-1] = room[room.length-2][room[0].length-1];

            for(int i=room.length-1; i>x; i--){
                room[i][room[0].length-1] = room[i-1][room[0].length-1];
            }
            room[x][room[0].length-1] = room[x-2][room[0].length-1];

            for(int i=room[0].length-1; i>0; i--){
                room[x][i] = room[x][i-1];
            }
            room[x][1] = 0;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int t = sc.nextInt();

        int[][] room = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                room[i][j] = sc.nextInt();
            }
        }

        while(t-->0){
            Queue<Position> q = new LinkedList<>();
            for(int i=0; i<r; i++){
                for(int j=0; j<c; j++){
                    if(room[i][j] != 0 && room[i][j] != -1){
                        q.add(new Position(i, j, room[i][j]));
                    }
                }
            }

            diffusion(q, room);

            for(int i=0; i<r; i++){
                if(room[i][0] == -1){
                    circulationLeft(i, room);
                    circulationRight(i+1, room);
                    break;
                }
            }

        }

        int result = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(room[i][j] != -1)result += room[i][j];
            }
        }
        System.out.println(result);
    }
}
