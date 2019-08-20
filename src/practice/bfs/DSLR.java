package practice.bfs;

import java.util.*;


//9019번
//어떤 연산을 통해서 만들어졌는자 출력
class Pair {
    int num ;
    String command ;
    Pair(int num, String command){
        this.num = num;
        this.command = command;
    }

}
public class DSLR {

    public static int[] nCheck = new int[30001];
    public static int[] npCheck = new int[30001];
    public static String[] cCheck = new String[30001];

    static int execD(int n){
        return (2*n)%10000;
    }

    static int execS(int n){
        n = n-1;
        if(n<=0) n = 9999;
        return n;
    }

    static int execL(int n){
        return (n%1000)*10 + n/1000;
    }

    static int execR(int n){
        return (n/10) + (n%10)*1000;
    }

    static void bfs(int a, int b){
        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(a, "");
        q.add(p);
        nCheck[a] += 1;

        while(!q.isEmpty()){
            if(nCheck[b] != 0) return ;
            Pair x = q.remove();

            ArrayList<Pair> nn = new ArrayList<>();
            Pair p1 = new Pair(execD(x.num), "D");
            Pair p2 = new Pair(execS(x.num), "S");
            Pair p3 = new Pair(execL(x.num), "L");
            Pair p4 = new Pair(execR(x.num), "R");
            nn.add(p1); nn.add(p2); nn.add(p3); nn.add(p4);
            for(Pair y : nn){
                if(y.num>=0 && y.num < 30001 && nCheck[y.num]==0){
                    nCheck[y.num] = nCheck[x.num]+1;
                    npCheck[y.num] = x.num;
                    cCheck[y.num] = y.command;
                    q.add(y);
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            Arrays.fill(nCheck, 0);
            Arrays.fill(npCheck, 0);
            Arrays.fill(cCheck, "");

            int a = sc.nextInt();
            int b = sc.nextInt();

            bfs(a,b);
            int sec = nCheck[b]-1;

            ArrayList<String> r = new ArrayList<>();

            int num = b;
            while(sec-->0){
                r.add(cCheck[num]);
                num = npCheck[num];
            }
            for(int i=r.size()-1; i>=0; i--){
                System.out.print(r.get(i));
            }
            System.out.println();
        }
    }
}
