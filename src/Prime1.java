import java.util.Scanner;

public class Prime1 {
    static boolean isPrime(int num){
        if(num == 1) return false;
        for(int i = 2; i*i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] num = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            num[i] = scan.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if(isPrime(num[i])) count ++;
        }

        System.out.println(count);
    }
}
