package programmers;
import java.lang.reflect.Array;
import java.util.*;

public class SameNumber {
    public static int[] solution(int []arr) {
        int[] answer;
        ArrayList list = new ArrayList();
        list.add(arr[0]);
        for(int i=1; i<arr.length; i++){
            if(arr[i] != arr[i-1]){
                list.add(arr[i]);
            }
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = (int)list.get(i);
        }
        return answer;
    }
    public static void main(String[] args){
        int arr[] = {1,1,3,3,0,1,1};
        int[] answer = solution(arr);
        for(int i=0; i<answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
