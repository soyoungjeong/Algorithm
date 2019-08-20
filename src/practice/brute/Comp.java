package practice.brute;

import java.util.Arrays;
import java.util.*;

public class Comp {
    public static void main(String[] args) {

        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        Arrays.sort(strings,new Comparator<String>() {
        @Override
        public int compare (String o1, String o2){
            if (o1.charAt(n) > o2.charAt(n)) {
                return 1;
            } else if (o1.charAt(n) < o2.charAt(n)) {
                return -1;
            } else {
                return o1.compareTo(o2);
            }
        }
        });

        System.out.println(strings);


        String s = "Zbcdefg";
        String[] str = new String[s.length()];
        for(int i=0; i<str.length; i++){
            str[i] = String.valueOf(s.charAt(i));
        }
        Arrays.sort(str,new Comparator<String>() {
            @Override
            public int compare (String o1, String o2){
                if (o1.charAt(0) > o2.charAt(0)) {
                    return -1;
                } else if (o1.charAt(0) < o2.charAt(0)) {
                    return 1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

    }
}
