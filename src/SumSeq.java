import java.util.Scanner;

public class SumSeq {
    public static int count = 0;
    static void go(int[] a, int sum, int s, int index){
        if(sum == s){
            count ++;
            return ;
        }
        if(index == a.length || sum > s) return ;
        go(a, sum + a[index], s, index + 1);
        go(a, sum, s, index + 1);
        return ;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int s = scan.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = scan.nextInt();
        }
        go(a, 0, s, 0);
        System.out.println(count);
    }
}
