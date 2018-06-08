package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 3. 14..
 */
public class BJ7576 {
    public static int[] dx = new int[]{1,-1,0,0};
    public static int[] dy = new int[]{0,0,1,-1};

    public static int solution(int[][] input){
        int h = input.length;
        int w = input[0].length;
        List<Point> positons = new ArrayList<>();

        for(int i = 0; i < h; ++i ){
            for(int j = 0; j < w; ++j){
                if(input[i][j] == 1){
                   positons.add(new Point(i, j));
                }
            }
        }

        for(Point start:positons){
            bfs(input, start);
        }

        return checkMap(input, h, w);

    }

    private static int checkMap(int[][] input, int h, int w) {
        int output = 0;
        for(int i = 0; i < h; ++i ){
            for(int j = 0; j < w; ++j){
               if(input[i][j] > output){
                   output = input[i][j];
               }

               if(input[i][j] == 0){
                   return - 1;
               }
            }
        }

        return output-1;
    }

    static class Point{
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs(int[][] input, Point start){

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(start.x, start.y));

        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();

            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(inRange(input, nx, ny)){
                    int nextdate = input[x][y] + 1;
                    if(input[nx][ny] == 0){
                        input[nx][ny] = nextdate;
                        q.offer(new Point(nx, ny));
                    }else{
                        if(input[nx][ny] > nextdate){
                            input[nx][ny] = nextdate;
                            q.offer(new Point(nx, ny));
                        }
                    }
                }
            }
        }
    }

    public static boolean inRange(int[][] input, int x, int y){
        return 0 <= x && x < input.length && 0 <= y && y < input[0].length;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();

        int[][] input = new int[h][w];
        for(int i = 0; i < h; ++i ){
            for(int j = 0; j < w; ++j){
                input[i][j] = sc.nextInt();
            }
        }

        int output = solution(input);
        System.out.println(output);

        for(int i = 0; i < h; ++i ){
            for(int j = 0; j < w; ++j){
               System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }
}
