package basic;

import java.util.Arrays;
import java.util.Scanner;

public class Seven {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[] height = new int[9];
        int sum = 0;
        int ans = 0;

        for(int i = 0; i < 9; i++){
            height[i] = scan.nextInt();
            sum += height[i];
        }
        for(int i = 0; i < 8; i++){
            if(ans == 100) break;
            for(int j = i+1; j < 9; j++){
                ans = sum - (height[i] + height[j]);
                if(ans == 100){
                    height[i] = 0;
                    height[j] = 0;
                    break;
                }
            }
        }
        Arrays.sort(height);
        for(int i = 2; i < 9; i++){
            System.out.println(height[i]);
        }
    }
}
