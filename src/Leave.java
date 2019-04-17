import java.util.Scanner;

public class Leave {
    public static int max = 0;
    static void go(int[] t, int[] p, int day, int sum){
        if(day == t.length){
            if(max < sum) max = sum;
            return;
        }
        go(t, p, day+1, sum);
        if(day+t[day] <= t.length) {
            go(t, p, day + t[day], sum + p[day]);
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int t[] = new int[n];
        int p[] = new int[n];

        for(int i = 0; i < n; i++){
            t[i] = scan.nextInt();
            p[i] = scan.nextInt();
        }
        go(t, p, 0, 0);

        System.out.println(max);
    }
}
