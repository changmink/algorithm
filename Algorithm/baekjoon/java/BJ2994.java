package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 29..
 */
import java.util.*;
public class BJ2994 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] values = new int[101];
        int[] dp = new int[10001];
        for(int i = 1 ; i <= n; ++i){
            values[i] = scanner.nextInt();
        }

        dp[0] = 1;
        for(int coin = 1; coin <= n; ++coin){
           for(int target = 0; target <= k; ++target){
               if(target - values[coin] >= 0){
                   dp[target] += dp[target - values[coin]];
               }
           }
        }

        System.out.println(dp[k]);
    }
}
