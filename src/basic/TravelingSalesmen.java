package basic;

import java.util.Scanner;

public class TravelingSalesmen {
    static void swap(int[] p, int i, int j){
        int temp = p[i];
        p[i] = p[j];
        p[j] = temp;
    }
    static boolean next_permutation(int[] p){
        int i = p.length - 1;
        while(i > 0 && p[i-1] >= p[i]) i-=1;
        if(i <= 0) return false;
        int j = p.length - 1;
        while(p[i-1] >= p[j]) j-=1;
        swap(p, i-1, j);
        j = p.length - 1;
        if(i < j){
            swap(p, i, j);
            i += 1; j -= 1;
        }
        return true;
    }
    static int sum(int[][] w, int[] p){
        int result = 0;

        for(int i = 0; i < p.length - 1; i++){
            if(w[p[i]-1][p[i+1]-1] == 0){
                return 0;
            }
            result += w[p[i]-1][p[i+1]-1];
        }
        if(w[p[p.length-1]-1][p[0]-1] == 1){
            return 0;
        }
        result += w[p[p.length-1]-1][p[0]-1];

        return result;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] w = new int[n][n];
        int[] p = new int[n];
        int min = 6000000;

        for(int i = 0; i < n; i++){
            p[i] = i + 1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                w[i][j] = scan.nextInt();
            }
        }

        do {
            int result = sum(w, p);
            if(result != 0){
                if(min > result) min = result;
            }
        }while(next_permutation(p));

        System.out.println(min);


    }
}
