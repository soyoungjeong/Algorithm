package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class WordMath {
    public static void swap(int[] p, int a, int b){
        int temp = p[a];
        p[a] = p[b];
        p[b] = temp;
    }
    static boolean next_permutation(int[] p, int n){
        int i = n - 1;
        while(i > 0 && p[i-1] >= p[i]) i-=1;
        if(i <= 0) return false;
        int j = n - 1;
        while(p[i-1] >= p[j]) j-=1;
        swap(p, j, i-1);
        j = n - 1;
        while(i < j){
            swap(p, i, j);
            i += 1; j -= 1;
        }
        return true;
    }
    static int[] alpha = new int[256];
    public static int calc(String[] a, Character[] letters, int[] d){
        int m = letters.length;
        int sum = 0;
        for(int i=0; i<m; i++){
            alpha[letters[i]] = d[i];
        }


        //이부분 원래 내가 했던대로 하면 시간초과 ㅠㅠ 
        for (String s : a) {
            int now = 0;
            for (char x : s.toCharArray()) {
                now = now * 10 + alpha[x];
            }
            sum += now;
        }



        return sum;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Character> letter = new HashSet<>();
        String[] a = new String[n];
        int j = 0;
        while(n-->0){
            a[j] = sc.next();
            for(int i=0; i<a[j].length(); i++){
                char temp = a[j].charAt(i);
                letter.add(temp);
            }
            j++;
        }

        Character[] letters = letter.toArray(new Character[letter.size()]);
        int m = letters.length;
        int[] d = new int[m];
        for(int i=9; i>9-m; i--){
            d[9-i] = i;
        }
        Arrays.sort(d);
        int ans = 0;
        do{
            int now = calc(a, letters, d);
            if(ans < now) {
                ans = now;
            }
        }while(next_permutation(d, m));
        System.out.println(ans);
    }
}
