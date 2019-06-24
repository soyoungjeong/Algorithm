package basic;

import java.util.*;

public class Nm10 {
    public static int[] p;
    public static boolean[] v;
    public static LinkedHashSet<String> set = new LinkedHashSet<>();
    static void go(int[] num, int index, int n, int m, int cur) {
        if (cur == m) {
            String s = "";
            for (int i = 0; i < m; i++) {
                s += p[i] + " ";
            }
            set.add(s);
            return;
        }

        if(index >= n) return ;
        else p[cur] = num[index];
        go(num, index + 1, n, m, cur + 1);
        go(num, index + 1, n, m, cur);
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] num = new int[n];
        p = new int[m+2];
        v = new boolean[10001];
        for(int i = 0; i < n; i++){
            num[i] = scan.nextInt();
        }
        Arrays.sort(num);
        go(num, 0, n, m, 0);

        String[] ans;
        ans = set.toArray(new String[0]);

        for(int i = 0; i < set.size(); i++){
            System.out.println(ans[i]);
        }
    }
}