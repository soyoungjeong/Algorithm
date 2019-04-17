import java.util.Scanner;

public class PutOperator {
    public static int min = 1000000000;
    public static int max = -1000000000;
    static void go(int[] a, int index, int ans, int plus, int minus, int mul, int div){
        if(index >= a.length){
            if(ans < min) min = ans;
            if(ans > max) max = ans;
            return ;
        }
        if(plus > 0) go(a, index+1, ans + a[index], plus - 1, minus, mul, div);
        if(minus > 0) go(a, index+1, ans - a[index], plus, minus - 1, mul, div);
        if(mul > 0) go(a, index+1, ans * a[index], plus, minus, mul - 1, div);
        if(div > 0) go(a, index+1, ans / a[index], plus, minus, mul, div - 1);
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        int[] o = new int[4];

        for(int i = 0; i < n; i++){
            a[i] = scan.nextInt();
        }

        for(int i = 0; i < 4; i++){
            o[i] = scan.nextInt();
        }

        go(a, 1, a[0], o[0], o[1], o[2], o[3]);

        System.out.println(max);
        System.out.println(min);
    }
}
