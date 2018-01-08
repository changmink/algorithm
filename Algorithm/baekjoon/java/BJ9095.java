package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 29..
 */
import java.util.*;
public class BJ9095 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int tc = scanner.nextInt();
        while(tc-- > 0){
            int n = scanner.nextInt();
            int dp[] = new int[12];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for(int i = 4; i <= n; ++i){
                for(int j = 1; j <= 3; ++j){
                    dp[i] += dp[i-j];
                }
            }

            System.out.println(dp[n]);
        }
    }
}
