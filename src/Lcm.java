import java.util.Scanner;

public class Lcm {
    static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        else{
            return gcd(b, a%b);
        }
    }
    static int lcm(int a, int b){
        int g = gcd(a, b);
        return g * (a/g) * (b/g);
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int a;
        int b;
        for(int i = 0; i < t; i++){
            a = scan.nextInt();
            b = scan.nextInt();

            System.out.println(lcm(a,b));
        }
    }
}
