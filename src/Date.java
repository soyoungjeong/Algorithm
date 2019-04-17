import java.util.Scanner;

public class Date {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int E = scan.nextInt();
        int S = scan.nextInt();
        int M = scan.nextInt();
        int year = 1;
        int e = 1;
        int s = 1;
        int m = 1;

        while(e != E || s != S || m != M){
            year ++;

            e ++;
            if(e == 16){
                e = 1;
            }

            s++;
            if(s == 29){
                s = 1;
            }

            m++;
            if(m == 20){
                m = 1;
            }
        }
        System.out.println(year);

    }
}
