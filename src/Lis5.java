import java.util.Arrays;
import java.util.Scanner;

public class Lis5 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scan.nextInt();
            d[i] = a[i];
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(a[i] > a[j] && d[i] < d[j] + a[i]){
                    d[i] = d[j] + a[i];
                }
            }
        }
        Arrays.sort(d);
        System.out.println(d[n-1]);
    }
}
