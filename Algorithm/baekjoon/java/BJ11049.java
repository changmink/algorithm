package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 1..
 */
import java.util.*;

public class BJ11049 {

    public static Scanner  scanner = new Scanner(System.in);
    public static void main(String[] args){
        int n = scanner.nextInt();
        int[][] input = new int[n+1][n+1];
        for(int i = 0; i < n; ++i){
            input[i][0] = scanner.nextInt();
            input[i][1] = scanner.nextInt();
        }

        int[][] DP = new int[n+1][n+1];

        int output = go(input, DP, 0, n-1);
        System.out.println(output);
    }

    public static int go(int[][] input, int[][] dp, int i, int j){
        if(dp[i][j] > 0)
            return dp[i][j];
        if(i == j)
            return 0;

        if(i+1 == j)
            return input[i][0] * input[i][1] * input[j][1];

        dp[i][j] = -1;
        for(int k = i; k < j; ++k){
            int t1 = go(input, dp, i, k);
            int t2 = go(input, dp, k + 1, j);
            int t3 = input[i][0] * input[k][1] * input[j][1];
            if(dp[i][j] == -1 || dp[i][j] > t1 + t2 + t3){
                dp[i][j] = t1 + t2 + t3;
            }
        }

        return dp[i][j];
    }
}

