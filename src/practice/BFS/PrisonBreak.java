package practice.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class PrisonBreak {
    public static boolean[][] check;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[][] bfs(String[][] map, int a, int b){
        int[][] result = new int[map.length][map[0].length];

        Deque<Pair2> q = new LinkedList<>();
        q.add(new Pair2(a, b));
        check[a][b] = true;

        while(!q.isEmpty()){
            Pair2 pair = q.removeFirst();
            int x = pair.first;
            int y = pair.second;
            for(int i=0; i<4; i++){
                int X = x + dx[i];
                int Y = y + dy[i];
                if(X >=0 && X < map.length && Y >= 0 && Y < map[0].length){
                    if(map[X][Y].equals("*")) continue;
                    if(!check[X][Y]){
                        if(map[X][Y].equals(".")) {
                            q.addFirst(new Pair2(X, Y));
                            result[X][Y] = result[x][y];
                            check[X][Y] = true;
                        }else if(map[X][Y].equals("#")){
                            q.addLast(new Pair2(X, Y));
                            result[X][Y] = result[x][y] + 1;
                            check[X][Y] = true;
                        }else{
                            if(a == 0 && b == 0){
                                q.addFirst(new Pair2(X, Y));
                                result[X][Y] = result[x][y] + 1;
                                check[X][Y] = true;
                            }
                            else{
                                q.addFirst(new Pair2(X, Y));
                                result[X][Y] = result[x][y];
                                check[X][Y] = true;
                            }
                        }
                    }
                }
            }
        }


        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            String[][] map = new String[h+2][w+2];
            check = new boolean[map.length][map[0].length];

            for(int i=0; i<map.length; i++){
                for(int j=0; j<map[0].length; j++){
                    if(i==0 || j==0) map[i][j] = ".";
                    if(i==map.length-1 || j==map[0].length-1) map[i][j] = ".";
                }
            }

            for(int i=1; i<h+1; i++){
                String[] str = br.readLine().split("");
                for(int j=1; j<w+1; j++){
                    map[i][j] = str[j-1];
                }
            }

            int[][] outside = bfs(map, 0 ,0);
            int[][] firstPrisoner;
            int[][] secondPrisoner;
            ArrayList<Integer> prisonerPosition = new ArrayList<>();

            for(int i=0; i<h+1; i++){
                for(int j=0; j<w+1; j++){
                    if(map[i][j].equals("$")){
                        prisonerPosition.add(i);
                        prisonerPosition.add(j);
                    }

                }
            }

            check = new boolean[map.length][map[0].length];
            firstPrisoner = bfs(map, prisonerPosition.get(0), prisonerPosition.get(1));
            check = new boolean[map.length][map[0].length];
            secondPrisoner = bfs(map, prisonerPosition.get(2), prisonerPosition.get(3));

            int min = 10000000;
            for(int i=0; i<h+2; i++){
                for(int j=0; j<w+2; j++){
                    outside[i][j] += firstPrisoner[i][j] + secondPrisoner[i][j];
                    if(map[i][j].equals("#")){
                        outside[i][j] -= 2;
                    }
                    if(!map[i][j].equals("*")) min = Math.min(min, outside[i][j]);
                }
            }


            System.out.println(min);

        }
    }
}
