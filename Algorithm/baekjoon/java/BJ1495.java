package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 2..
 */
import java.util.*;
public class BJ1495 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int max = scanner.nextInt();

        int[] volume = new int[n];
        for(int i = 0; i < n; ++i){
            volume[i] = scanner.nextInt();
        }

        boolean[][] dp = new boolean[n+1][max+1];
        dp[0][s] = true;

        for(int i = 0; i <= n-1; ++i){
            for(int j = 0; j <= max; ++j){
                if(dp[i][j] == true){
                    if(j + volume[i] <= max){
                        dp[i+1][j + volume[i]] = true;
                    }

                    if(j - volume[i] >= 0){
                        dp[i+1][j - volume[i]] = true;
                    }
                }
            }
        }

        int output = -1;
        for(int i = 0; i <= max; ++i){
            if(dp[n][i])
                output = i;
        }

        System.out.println(output);

    }
}
