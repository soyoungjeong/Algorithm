import java.util.Scanner;

public class Goldbach {
    static boolean isPrime(int n){
        if(n == 1) return false;
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n;
        int a=1;
        int b=1;

        do{
            n = scan.nextInt();

            for(int i = 3; i < n; i++){
                if(isPrime(i)){
                    a = i;
                    if(isPrime(n - a)){
                        b = n -a;
                        System.out.println(n + " = " + a + " + " + b);
                        break;
                    }
                }
            }
            if(a == 1){
                System.out.println("Goldbach's conjectrue is wrong.");
            }
        }while(n!=0);
    }
}
