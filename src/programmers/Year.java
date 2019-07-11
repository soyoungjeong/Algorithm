package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Year {
    public static String solution(int a, int b) {
        String answer = "";
        String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int now = 5;
        for(int i=1; i<a; i++){
            if(i==2){
                now += 1;
            }
            else if(i==8){
                now += 3;
            }
            else{
                if(i%2 == 1){
                    now += 3;
                }
                else {
                    now += 2;
                }
            }
            System.out.println(now);
            if(now >= 7) now -= 7;
        }

        for(int i=1; i<b; i++){
            now += 1;
            if(now >= 7) now -= 7;
        }

        answer = day[now];
        return answer;
    }
    public static void main(String[] args){
        int a = 3;
        int b = 1;
        System.out.println(solution(a, b));
    }
}
