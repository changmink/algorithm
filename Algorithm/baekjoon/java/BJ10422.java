package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 27..
 */
import java.util.*;
public class BJ10422 {
    public static Scanner scanner = new Scanner(System.in);
    public static final long MOD = 1000000007;
    public static void main(String[] args){
        //테스트 케이스가 있으므로 미리 계산해 둔다.
        long dp[] = new long[2501];
        dp[0] = 1;
        for(int i = 1; i <= 2500; ++i){
            dp[i] = 0;

            for(int j = 0; j < i; ++j){
                dp[i] += dp[j] * dp[i - 1 - j];
                dp[i] %= MOD;
            }

            dp[i] %= MOD;
        }

        int t = scanner.nextInt();
        for(int i = 0; i < t; ++i){
            int n = scanner.nextInt();
            long output = (n % 2 == 0)? dp[n/2] : 0;
            System.out.println(output);
        }
    }
}
