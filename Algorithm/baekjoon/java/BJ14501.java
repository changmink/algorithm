package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 4. 7..
 */
public class BJ14501 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n+1];
        int[] t = new int[n+1];
        int[] dp = new int[n+1];

        for(int i = 1; i <= n; ++i){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        // 마지막 인덱스 처리
        if(t[n] <= 1){
            dp[n] = p[n];
        }

        //마지막 인덱스 - 1 부터 시작
        for(int i = n - 1; i >= 0; --i){
            //현재가 가능한지 확인한다.
            if(t[i] + i >= n ){
                dp[i] = Math.max(dp[i+1], 0);
            }
            else {
                dp[i] = Math.max(dp[i + 1], p[i] + dp[i + t[i]]);
            }

        }

        System.out.println(dp[0]);
    }
}
