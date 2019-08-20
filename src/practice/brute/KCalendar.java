package practice.brute;

import java.util.Scanner;

public class KCalendar {
    public static int lcm(int num1, int num2) {
        int a = num1, b = num2;

        while (b != 0) {
        int temp = a % b;
        a = b;
        b = temp;
    }
        return num1 * num2 / a;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            /*int temp;
            if(x>y){
                temp = x;
                x = y;
                y = temp;

                temp = m;
                m = n;
                n = temp;
            }*/
            int year = x;
            boolean isPossible = false;

            while(year<=lcm(m,n)){
                if(x==y){
                    isPossible = true;
                    break;
                }
                if(year%n == y || year%n == y%n){
                    isPossible = true;
                    break;
                }
                year += m;
            }

            if(isPossible) System.out.println(year);
            else System.out.println(-1);
        }
    }
}
