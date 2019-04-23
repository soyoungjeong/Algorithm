import java.util.Arrays;
import java.util.Scanner;

public class Lis6 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scan.nextInt();
            d[i] = 1;
        }

        for(int i = n-1; i >= 0; i--){
            for(int j = n-1; j >= i; j--){
                if(a[i] > a[j] && d[i] < d[j] + 1){
                    d[i] = d[j] + 1;
                }
            }
        }

        Arrays.sort(d);
        System.out.println(d[n-1]);
    }
}
