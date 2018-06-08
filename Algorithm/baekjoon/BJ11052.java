package baekjoon;

import java.util.*;

/**
 * Created by changmin on 2018. 4. 26..
 */
public class BJ11052 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] price = new int[n+1];
        for(int i = 1; i <=n; ++i){
            price[i] = sc.nextInt();
        }
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= i; ++j){
                dp[i] = Math.max(dp[i], price[j] + dp[i-j]);
            }
        }

        System.out.println(dp[n]);
    }
}
