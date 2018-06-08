package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 3. 14..
 */
public class BJ4963 {
    static int[] dx = new int[]{0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dy = new int[]{1, -1, 0, -1, 1, 0, 1, -1};
    public static void fill(int[][] input, int x, int y){
        if(x < 0 || y < 0 || x >= input.length || y >= input[0].length) {
            return;
        }

        if(input[x][y] <= 0 || input[x][y] >= 2){
            return;
        }

        input[x][y] = 0;

//        bfs(input, x-1, y);
//        bfs(input, x, y+1);
//        bfs(input, x+1, y);
//        bfs(input, x, y+1);
//
//        bfs(input, x-1, y-1);
//        bfs(input, x-1, y+1);
//        bfs(input, x+1, y-1);
//        bfs(input, x+1, y+1);
        for(int i = 0; i < 8; ++i){
            fill(input, x + dx[i], y + dy[i]);
        }
    }

    private static int floodfill(int[][] input) {
        int count = 0;
        for(int i = 0; i < input.length; ++i){
            for(int j = 0; j < input[0].length; ++j){
                if(input[i][j] == 1){
                    count += 1;
                    fill(input, i, j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true){
            int[] size = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if(size[0] == 0 && size[1] == 0) {
                break;
            }

            int w = size[0];
            int h = size[1];

            int[][] input = new int[h][w];

            for(int i = 0; i < h; ++i) {
                int[] row = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                input[i] = row;
            }

            System.out.println(floodfill(input));
        }

    }
}
