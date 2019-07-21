package practice.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair2{
    final int first;
    final int second;

    Pair2(int first, int second){
        this.first = first;
        this.second = second;
    }
}

//2251번
public class Bucket {
    public static final int[] from = {0, 0, 1, 1, 2, 2};
    public static final int[] to = {1, 2, 0, 2, 0, 1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] bucket = new int[3];
        for(int i=0; i<3; i++){
            bucket[i] = sc.nextInt();
        }

        int sum = bucket[2];

        //A, B 체크
        boolean[][] check = new boolean[201][201];
        //c 체크
        boolean[] ans = new boolean[201];


        //bfs 시작
        //q에는 A,B의 상태만 넣는다 => C는 처음 C에서 A,B 빼면 됨

        //처음 상태 넣기
        Queue<Pair2> q = new LinkedList<Pair2>();
        q.add(new Pair2(0,0));
        check[0][0] = true;
        ans[sum] = true;

        //다음상태부터 고고
        //숨바꼭질4랑 비슷하게 생각해보즈아
        while(!q.isEmpty()){
            int[] cur = new int[3];
            Pair2 p = q.peek();
            cur[0] = p.first;
            cur[1] = p.second;
            cur[2] = sum - cur[0] - cur[1];
            q.remove();

            for(int i=0; i<6; i++){
                int[] next = {cur[0], cur[1], cur[2]};
                next[to[i]] += next[from[i]];
                next[from[i]] = 0;

                //받는애가 용량을 초과한 경우 부은애한테 돌려줘야한다
                if(next[to[i]] >= bucket[to[i]]){
                    next[from[i]] = next[to[i]] - bucket[to[i]];
                    next[to[i]] = bucket[to[i]];
                }

                //방문한적 없는 용량이면 방문~!
                if(!check[next[0]][next[1]]){
                    check[next[0]][next[1]] = true;
                    q.add(new Pair2(next[0], next[1]));

                    //A가 0이면 정답~
                    if(next[0] == 0){
                        ans[next[2]] = true;
                    }
                }
            }
        }
        for(int i=0; i<=bucket[2]; i++){
            if(ans[i]){
                System.out.println(i+" ");
            }
        }
        System.out.println();
    }
}
