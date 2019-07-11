package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Kth {
    public static void main(String[] args){
        int[] array = { 1,100,2,6,3,7,4 };
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        int[] answer = new int[commands.length];
        int[] numTemp;
        int k=0;
        for(int i=0; i<commands.length; i++){

            numTemp = new int[commands[i][1] - commands[i][0] + 1];
            for(int j=0; j<numTemp.length; j++){
                numTemp[j] = array[commands[i][0]-1+j];
            }
            //Arrays.copyOfRange(원본배열, 시작인덱스, 끝인덱스)

            Arrays.sort(numTemp);
            answer[k++] = numTemp[commands[i][2]-1];
        }

        System.out.println(answer[0]);
    }
}
