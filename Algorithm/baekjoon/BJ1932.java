package baekjoon;

import java.util.*;

public class BJ1932 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int n = scanner.nextInt();
        int[][] input = new int[n][n];

        for(int i = 0; i < n; ++i){
            for(int j = 0; j <= i; ++j){
                input[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < n-1; ++i){
            input[i+1][0] = input[i][0] + input[i+1][0];
        }

        for(int row = 1; row < n; ++row){
            for(int col = 1; col < n; ++col){
                input[row][col] = input[row][col] + Math.max(input[row-1][col-1], input[row-1][col]);
            }
        }

        int output = Arrays.stream(input[n-1]).max().getAsInt();
        System.out.println(output);
    }
}
