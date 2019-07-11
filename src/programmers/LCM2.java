package programmers;

import java.util.Arrays;

public class LCM2 {
    public static int solution(int[] arr) {
        int answer = 1;
        boolean result;
        Arrays.sort(arr);
        for(int i=1; i<=arr[arr.length-1]; i++){
            result = true;
            int temp = arr[arr.length-1]*i;
            for(int j=0; j<arr.length; j++){
                if(temp%arr[j]!=0){
                    result = false;
                    break;
                }
            }
            if(result){
                answer = temp;
                break;
            }
        }
        if(answer == 1){
            for(int j=0; j<arr.length; j++){
                answer *= arr[j];
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int[] arr = {15, 20, 30};
        System.out.println(solution(arr));
    }
}
