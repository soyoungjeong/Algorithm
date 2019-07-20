package practice.BFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//13913번
//bfs방문한 경로 출력해야됨
public class HideSeek4 {
    public static Queue<Integer> q = new LinkedList();
    public static int[] check = new int[10000001];
    public static int[] preNum = new int[10000001];
    static void bfs(int v, int k){
        q.add(v);
        check[v] += 1;
        while(!q.isEmpty()){
            if(check[k] != 0) return ;
            int x = q.remove();

            ArrayList<Integer> a = new ArrayList<>();
            a.add(x-1); a.add(x+1); a.add(x*2);

            for(int y : a){
                if(y >= 0 && y < 10000001 && check[y] == 0){
                    check[y] = check[x] + 1;
                    preNum[y] = x;
                    q.add(y);
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();


        bfs(n, k);
        int sec = check[k]-1;
        System.out.println(sec);


        //n에서 k로 가는 루트를 저장하고 출력하는 부분
        ArrayList<Integer> route = new ArrayList<>();
        int num = k;
        while(sec-->=0){
            route.add(num);
            num = preNum[num];
        }
        for(int i=route.size()-1; i>=0; i--){
            System.out.print(route.get(i) + " ");
        }
    }
}
