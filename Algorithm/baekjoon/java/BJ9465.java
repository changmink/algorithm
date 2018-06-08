package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 5. 9..
 * http://www.crocus.co.kr/479 다른 풀이 - > 안되는데 ㅡㅡ
 */
public class BJ9465 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        while(testcase-- > 0){
            int n = sc.nextInt();
            sc.nextLine();
            int input[][] = new int[2][n];
            input[0] = Arrays.stream(sc.nextLine().split(" "))
                                .mapToInt(x -> Integer.parseInt(x))
                                .toArray();

            input[1] = Arrays.stream(sc.nextLine().split(" "))
                            .mapToInt(x -> Integer.parseInt(x))
                            .toArray();

            long[][] dp = new long[3][n+1];

            for(int i = 1; i <= n; ++i){
                dp[0][i] = Math.max(input[0][i-1], Math.max(dp[1][i-1], dp[2][i-1]));
                dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1]) + input[0][i-1];
                dp[2][i] = Math.max(dp[0][i-1], dp[1][i-1]) + input[1][i-1];
            }

            System.out.println(Math.max(dp[0][n], Math.max( dp[1][n], dp[2][n])));
        }

    }
}
