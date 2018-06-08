package baekjoon.java;

import java.io.*;
import java.util.*;

/**
 * Created by changmin on 2018. 3. 15..
 */
public class BJ2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = size[0];
        int m = size[1];

        int[][] input = new int[n][m];
        for(int i = 0; i < n; ++i) {
            int[] row = Arrays.stream(reader.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            input[i] = row;
        }

        bfs(input);

        System.out.println(input[n-1][m-1]);
    }

    static class Point{
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    public static int[] dx = new int[]{1,0,-1,0};
    public static int[] dy = new int[]{0,1,0,-1};

    public static void bfs(int[][] input){
       Queue<Point> q = new LinkedList<>();
       q.offer(new Point(0, 0));

       while(!q.isEmpty()){
           int x = q.peek().x;
           int y = q.peek().y;
           q.poll();

           for(int i = 0; i < dx.length; ++i){
               int nx = x + dx[i];
               int ny = y + dy[i];
               if(0 <= nx && nx < input.length && 0 <= ny && ny < input[0].length){
                  if(input[nx][ny] == 1){
                      input[nx][ny] = input[x][y] + 1;
                      q.offer(new Point(nx, ny));
                  }else{
                      if(input[nx][ny] > input[x][y] + 1){
                        input[nx][ny] = input[x][y] + 1;
                        q.offer(new Point(nx, ny));
                      }
                  }
               }
           }
       }
    }
}
