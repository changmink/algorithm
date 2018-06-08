package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 5. 2..
 */
public class BJ11057 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[][] dp = new long[n+1][10];
        for(int i = 0; i <= 9; ++i){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; ++i){
            for(int j = 0; j <= 9; ++j){
                for(int k = 0; k <=j; ++k){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        long output = 0;
        for(int i = 0; i <= 9; ++i){
            output += dp[n][i];
            output %= 10007;
        }

        System.out.print(output);
    }
}
