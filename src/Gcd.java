import java.util.Scanner;

public class Gcd {
    static int gcd1(int a, int b){
        int n = 1;
        int small;

        small = Math.min(a, b);

        for(int i = 1; i <= small; i++){
            if(a % i == 0 && b % i == 0){
                n = i;
            }
        }
        return n;
    }

    static int gcd2(int a, int b){
        if(b == 0){
            return a;
        }
        else{
            return gcd2(b, a%b);
        }
    }

    static int lcm(int a, int b){
        int g = gcd1(a, b);
        return g * (a/g) * (b/g);
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();

        System.out.println(gcd2(a,b));
        System.out.println(lcm(a,b));
    }
}
