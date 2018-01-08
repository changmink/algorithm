package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 1. 1..
 */
public class BJ2228 {
    public static boolean check[][] = new boolean[101][101];
    public static int dp[][] = new int[101][101];
    //언더 플로우 방지. 너무 작으면 합이 음수일 경우 언더 플로우 발생 우려
    public static int min = -32786*101;

    public static int go(int[] input, int[] sum, int n, int m){
        if(m == 0) return 0;//m개의 구간이 모두 있음
        if(n <= 0) return min;//더 이상 사용 할 수 없는 경우 m > 0
        if(check[n][m]) return dp[n][m];

        check[n][m] = true;
        dp[n][m] = go(input, sum, n-1, m);//포함하지 않는 경우
        for(int i = 1; i <=n; ++i){
            int temp = go(input, sum, i-2, m-1) + sum[n] - sum[i-1];
            dp[n][m] = Math.max(dp[n][m], temp);
        }

        return dp[n][m];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] input = new int[n+1];
        int[] sum = new int[n+1];

        for(int i = 1; i <= n; ++i){
            input[i] = sc.nextInt();
            sum[i] = sum[i-1] + input[i];
        }

        int output = go(input, sum, n, m);
        System.out.println(output);
    }
}
