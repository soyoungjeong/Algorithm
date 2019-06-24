package practice;

import java.util.Scanner;

public class Remote {
    public static boolean[] broken = new boolean[10];

    static int check(int c) {
        if(c==0){
            if(broken[0]) return 0;
            else return 1;
        }
        int len = 0;
        while(c>0){
            if(broken[c%10]){
                return 0;
            }
            c = c/10;
            len+=1;
        }
        return len;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i=0; i<m; i++){
            int b = sc.nextInt();
            broken[b] = true;
        }

        //경우1. 100에서 +,- 눌렀을 때
        int ans = n - 100;
        if(ans<0){
            ans = -ans;
        }

        //경우2. 번호 누르고 +나 - 눌렀을 때
        for(int i=0; i<=1000000; i++){
            int c = i;
            int len = check(c);
            if(len > 0){
                int press = Math.abs(c - n);
                if(ans > len+press){
                    ans = len+press;
                }
            }
        }

        System.out.println(ans);
    }
}
