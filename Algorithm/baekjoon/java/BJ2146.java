package baekjoon.java;

import java.util.*;
public class BJ2146 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = Integer.parseInt(sc.nextLine());
        int[][] input = new int[n][];
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; ++i){
            int[] row = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            input[i] = row;
        }

        int count = 1;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(input[i][j] == 1 && visited[i][j] == false){
                   bfsLabel(input, new Pair(i, j), ++count, visited);
                }
            }
        }

        Queue<Pair> labels = new LinkedList<>();
        int[][] bridge = new int[n][n];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                bridge[i][j] = -1;
                if(input[i][j] != 0){
                    bridge[i][j] = 0;
                    labels.add(new Pair(i ,j));
                }
            }
        }



        bfsRange(bridge, input, labels);

        int min = -1;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                for(int k = 0; k < dx.length; ++k){
                    int x = i + dx[k];
                    int y = j + dy[k];

                    if(0 <=x && x < input.length && 0 <= y && y < input[0].length) {
                        if (input[i][j] != input[x][y]){
                            int cost = bridge[i][j] + bridge[x][y];
                            if(min == -1 || min > cost){
                                min = cost;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(min);

    }

    static class Pair{
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};

    static void bfsLabel(int[][] input, Pair start, int count, boolean[][] visited){
        Queue<Pair> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y] = true;
        input[start.x][start.y] = count;
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();

            for(int i = 0; i < dx.length; ++i){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0 <=nx && nx < input.length && 0 <= ny && ny < input[0].length){
                    if(input[nx][ny] == 1 && visited[nx][ny] == false){
                        input[nx][ny] = count;
                        q.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                    }else continue;
                }
            }

        }
    }

    static void bfsRange(int[][] mark, int[][] input,  Queue<Pair> q ){

        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();

            for(int i = 0; i < dx.length; ++i){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0 <=nx && nx < input.length && 0 <= ny && ny < input[0].length){
                    if(mark[nx][ny] == -1 && input[nx][ny] == 0){
                        mark[nx][ny] = mark[x][y] + 1;
                        input[nx][ny] = input[x][y];
                        q.offer(new Pair(nx, ny));
                    }else continue;
                }
            }
        }
    }
}
