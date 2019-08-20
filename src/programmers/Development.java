package programmers;

import java.util.ArrayList;
import java.util.Scanner;

public class Development {
    static int[] solution(int[] progresses, int[] speeds){
        ArrayList<Integer> fin = new ArrayList<>();
        for(int i=0; i<progresses.length; i++){
            int day = (100 - progresses[i])/speeds[i];
            if((100 - progresses[i])%speeds[i] != 0) day += 1;
            fin.add(day);
            //System.out.println(day);
        }

        ArrayList<Integer> tmpAnswer = new ArrayList<>();
        int count = 1;
        int cnt = fin.get(0);
        fin.remove(0);
        while(fin.size() != 0){
            if(cnt >= fin.get(0)){
                count += 1;
            }else{
                tmpAnswer.add(count);
                cnt = fin.get(0);
                count = 1;
            }

            if(fin.size() > 1) fin.remove(0);
            else{
                tmpAnswer.add(count);
                fin.remove(0);
            }
        }

        int[] answer = new int[tmpAnswer.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = tmpAnswer.get(i);
            System.out.print(answer[i] + " ");
        }

        return answer;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] a = {40, 93, 30, 55, 60, 65};
        int[] b = {60, 1, 30, 5 , 10, 7};
        solution(a, b);
    }
}
