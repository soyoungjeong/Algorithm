package practice;

import java.util.Scanner;

public class Sudoku {
    public static int[][] sudoku = new int[9][9];
    public static boolean[][] c1 = new boolean[9][10];
    public static boolean[][] c2 = new boolean[9][10];
    public static boolean[][] c3 = new boolean[9][10];

    static boolean go(int z){
        if(z==81){
            for (int i=0; i<9; i++) {
                for (int j=0; j<9; j++) {
                    System.out.print(sudoku[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }

        int x = z/9;
        int y = z%9;
        if(sudoku[x][y] != 0){
            return go(z+1);
        }else {
            for(int i=1; i<=9; i++) {
                if (!c1[x][i] && !c2[y][i] && !c3[(x/3)*3+(y/3)][i]) {
                    c1[x][i] = c2[y][i] = c3[(x/3)*3+(y/3)][i] = true;
                    sudoku[x][y] = i;
                    if(go(z+1)){
                        return true;
                    }
                    sudoku[x][y] = 0;
                    c1[x][i] = c2[y][i] = c3[(x/3)*3+(y/3)][i] = false;
                }
            }
        }
        return false;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                sudoku[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(sudoku[i][j]!=0) {
                    c1[i][sudoku[i][j]] = true;
                    c2[j][sudoku[i][j]] = true;
                    c3[(i/3)*3+(j/3)][sudoku[i][j]] = true;
                }
            }
        }

        go(0);
    }
}
