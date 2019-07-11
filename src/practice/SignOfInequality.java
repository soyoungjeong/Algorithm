package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SignOfInequality {
    public static int k;
    public static String[] sign;
    public static boolean[] check = new boolean[10];
    public static ArrayList<String> list = new ArrayList<>();

    static void go(int index, int cnt, String result){
        if(index >= k){
            list.add(result);
            return ;
        }
        for(int i=0; i<=9; i++){
            if(sign[index].equals("<")){
                if(cnt < i && !check[i]){
                    check[i] = true;
                    go(index+1, i, result + i);
                    check[i] = false;
                }
            }
            if(sign[index].equals(">")){
                if(cnt > i && !check[i]){
                    check[i] = true;
                    go(index+1, i, result + i);
                    check[i] = false;
                }
            }
        }
        return ;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        sign = new String[k];
        for(int i=0; i<k; i++){
            sign[i] = sc.next();
        }

        for(int i=0; i<=9; i++){
            check[i] = true;
            go(0, i, String.valueOf(i));
            check[i] = false;
        }

        Collections.sort(list);
         System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }
}
