package programmers;

import java.util.Scanner;

public class Number124 {
    static String swap(String answer){
        return ( new StringBuffer(answer) ).reverse().toString();
    }
    static String solution(int n){
        String answer = "";
        while(n>3){
            int add = n%3;
            System.out.println(add);
            if(add == 0){ add = 4; n -= 1;}
            answer += String.valueOf(add);
            n = n/3;
        }
        if(n == 3) n = 4;
        answer += String.valueOf(n);
        System.out.println(answer);
        answer = swap(answer);
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }
}
