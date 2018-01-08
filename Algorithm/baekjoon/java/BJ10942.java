package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 28..
 */
public class BJ10942 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//1<=n<=2000
        int[] input = new int[n];//칠판에 적은수는 100000보다 작다.

        for(int i = 0 ; i < n; ++i){
            input[i] = scanner.nextInt();
        }

        boolean[][] dp = new boolean[n][n];

        //길이가 1인 경우
        for(int i = 0; i < n; ++i){
            dp[i][i] = true;
        }
        //길이가 2인 경우
        for(int i = 0; i < n - 1; ++i){
            if(input[i] == input[i+1]) {
                dp[i][i + 1] = true;
            }
        }

        //나머지 길이
        for(int k = 3; k <= n; ++k){
            for(int i = 0; i <= n - k; ++i){
                int j = i + k - 1;//이건 길이가 아니라 인덱스 이므로
                if(input[i] == input[j] && dp[i+1][j-1]){
                    dp[i][j] = true;
                }
            }
        }

        int m = scanner.nextInt();
        StringBuilder output = new StringBuilder();
        while(m-- > 0){
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            if(dp[s-1][e-1]){
                output.append(1);
            }
            else{
                output.append(0);
            }
            output.append('\n');
        }

        System.out.println(output);


    }
}
