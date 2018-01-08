package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 29..
 */
import java.util.*;
public class BJ1520 {
    public static int dp[][] = new int[500][500];

    public static int dy[] = {0, 0, 1, -1};
    public static int dx[] = {1, -1, 0, 0};

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] input = new int[n][m];

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                input[i][j] = scanner.nextInt();
            }
        }

        int output = bottomUp(input);//topDown(0,0, input);
        System.out.println(output);
    }

    public static int topDown(int x, int y, int[][] input){
        int n = input.length;
        int m = input[0].length;
        if(x == n - 1 && y == m - 1) return 1;
        if(dp[x][y] > 0) return dp[x][y];
        for(int k = 0; k < 4; ++k){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(0 <= nx && nx < n && 0 <= ny && ny < m){
                if(input[x][y] > input[nx][ny]) dp[x][y] += topDown(nx, ny, input);
            }
        }

        return dp[x][y];
    }
    static class Cell{
        public int row;
        public int col;
        public int val;

        public Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public static int bottomUp(int[][] input){
        int n = input.length;
        int m = input[0].length;
        List<Cell> sortedList = new ArrayList<>();
        for(int i = 0 ; i < n; ++i){
            for(int j =0; j < m; ++j) {
                sortedList.add(new Cell(i, j ,input[i][j]));
            }
        }
        sortedList.sort(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for(int i = 0; i < sortedList.size(); ++i){
            int x = sortedList.get(i).row;
            int y = sortedList.get(i).col;
            dp[n-1][m-1] = 1;
            for(int k = 0; k < 4; ++k){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(0 <= nx && nx < n && 0 <= ny && ny < m){
                    if(input[nx][ny] < input[x][y]){
                        dp[x][y] += dp[nx][ny];
                    }
                }
            }
        }
        return dp[0][0];
    }
}
