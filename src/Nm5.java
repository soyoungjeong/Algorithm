import java.util.Arrays;
import java.util.Scanner;

public class Nm5 {
    public static int[] p;
    public static boolean[] v;
    static void go(int[] num, int index, int n, int m){
        if(index == m){
            for(int i = 0; i < m; i++){
                System.out.print(p[i] + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < n; i++){
            if(v[num[i]] == false){
                v[num[i]] = true;
                p[index] = num[i];
                go(num, index + 1, n, m);
                v[num[i]] = false;
            }
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] num = new int[n];
        p = new int[m+2];
        v = new boolean[10001];
        for(int i = 0; i < n; i++){
            num[i] = scan.nextInt();
        }
        Arrays.sort(num);
        go(num,0, n, m);
    }
}
