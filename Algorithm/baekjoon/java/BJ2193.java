package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 5. 9..
 */
public class BJ2193 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[][] dp = new long[n+1][2];
        //처음에는 1만 가능 하다.
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i = 2; i <= n; ++i){
            //끝이 0인 경우와 끝이 1인 경우 모두 0이 올 수 있다.
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            //끝이 1인 경우에는 1만 올 수 있다.
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[n][1] + dp[n][0]);
    }
}
