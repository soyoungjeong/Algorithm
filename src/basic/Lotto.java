package basic;

import java.util.Scanner;

public class Lotto {
    static void go(int[] s, String lotto, int index, int count){
        if(count == 6){
            System.out.println(lotto);
            return ;
        }
        if(index >= s.length) return ;
        go(s, lotto+s[index]+" ", index + 1, count + 1);
        go(s, lotto, index + 1, count);
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int k;
        int[] s;

        do{
            k = scan.nextInt();
            s = new int[k];
            for(int i = 0; i < k; i++){
                s[i] = scan.nextInt();
            }
            go(s, "", 0, 0);
        }while(k != 0);
    }
}
