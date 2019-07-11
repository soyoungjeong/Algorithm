package practice;

import java.util.Scanner;

public class Alphabet {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static boolean[] check = new boolean[27];
    public static int answer = 0;
    static int go(Character[][] board, int a, int b){
        if(check[board[a][b]-65]) return 0;
        else{
            for(int i=0; i<4; i++){
                int X = a+dx[i];
                int Y = b+dy[i];
                if(X >= 0 && X < board.length && Y >= 0 && Y < board[0].length) {
                    //if(!check[board[a][b]-65]){
                        check[board[X][Y]-65] = true;
                        int next = go(board, X, Y);
                        answer = Math.max(answer, next);
                        check[board[X][Y]-65] = false;
                    //}
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        Character[][] board = new Character[r][c];

        for(int i=0; i<r; i++){
            String str = sc.next();
            for(int j=0; j<c; j++){
                char temp = str.charAt(j);
                board[i][j] = temp;
            }
        }
        check[board[0][0]-65] = true;
        System.out.println(go(board, 0,0));
    }
}
