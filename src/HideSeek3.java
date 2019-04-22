import java.util.ArrayDeque;
import java.util.Scanner;

public class HideSeek3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] d = new int[200002];
        boolean[] c = new boolean[200002];
        c[n] = true;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(n);
        if(n == k){
            d[k] = 0;
            c[k] = true;
        }
        while(!q.isEmpty()){
            int i = q.poll();
            if(c[k]){
                break;
            }
            int[] p = {i*2, i-1, i+1};
            for(int next : p){
                if(next >= 0 && next < d.length){
                    if(c[next] == false){
                        c[next] = true;
                        if(next == i*2){
                            q.addFirst(next);
                            d[next] = d[i];
                        }
                        else{
                            q.addLast(next);
                            d[next] = d[i] + 1;
                        }
                    }
                }
            }
        }
        System.out.println(d[k]);
    }
}
