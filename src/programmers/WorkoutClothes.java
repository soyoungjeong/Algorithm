package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class WorkoutClothes {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i=0; i<lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]){
                    answer+=1;
                    reserve[j] = 0;
                    lost[i] = 0;
                }
            }
        }
        System.out.println(answer);
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++) {
                if((reserve[j] != 0 && lost[i] != 0) && (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j])){
                    //System.out.println("lost : "+lost[i]);
                    //System.out.println("reserve : "+reserve[j]);
                    reserve[j] = 0;
                    answer+=1;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};
        System.out.println(solution(n, lost, reserve));
    }
}
