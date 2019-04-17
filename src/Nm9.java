import java.util.*;

public class Nm9 {
    public static int[] p;
    public static boolean[] v;
    public static LinkedHashSet<String> set = new LinkedHashSet<>();
    static void go(int[] num, int index, int n, int m) {
        if (index == m) {
            String s = "";
            for (int i = 0; i < m; i++) {
                s += p[i] + " ";
            }
            set.add(s);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(v[i] == false) {
                v[i] = true;
                p[index] = num[i];
                go(num, index + 1, n, m);
                v[i] = false;
            }
        }

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
        go(num, 0, n, m);

        String[] ans;
        ans = set.toArray(new String[0]);

        for(int i = 0; i < set.size(); i++){
            System.out.println(ans[i]);
        }
    }
}
