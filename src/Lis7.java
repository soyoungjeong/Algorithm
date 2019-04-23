import java.util.Arrays;
import java.util.Scanner;

public class Lis7 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        int[] d1 = new int[n];
        int[] d2 = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scan.nextInt();
            d1[i] = 1;
            d2[i] = 1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(a[i] > a[j] && d1[i] < d1[j] + 1){
                    d1[i] = d1[j] + 1;
                }
            }

            for(int k = n-1; k >= i; k--){
                for(int l = n-1; l >= k; l--){
                    if(a[k] > a[l] && d2[k] < d2[l] + 1){
                        d2[k] = d2[l] + 1;
                    }
                }
            }
            d[i] = d1[i] + d2[i];
        }

        Arrays.sort(d);
        System.out.println(d[n-1] - 1);
    }
}
