import java.util.Arrays;
import java.util.Scanner;

public class Lis {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = scan.nextInt();
            d[i] = 1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(a[i] > a[j]) {
                    d[i] = Math.max(d[j] + 1, d[i]);
                }
            }
        }

        Arrays.sort(d);
        System.out.println(d[n-1]);
    }
}
