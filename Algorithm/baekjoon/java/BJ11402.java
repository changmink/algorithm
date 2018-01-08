package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 27..
 */
import java.util.*;
public class BJ11402 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        int m = scanner.nextInt();

        long[][] dp = new long[m+1][m+1];
        for(int i = 0; i <= m; ++i){
            dp[i][0] = dp[i][i] = 1;
            for(int j = 1; j <= i - 1; ++j){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                dp[i][j] %= m;
            }
        }

        List<Integer> np = new LinkedList<>();
        List<Integer> kp = new LinkedList<>();

        while(n > 0 || k > 0){
            np.add((int) (n % m));
            kp.add((int) (k % m));

            n /= m;
            k /= m;
        }

        long output = 1;

        for(int i = 0; i < np.size(); ++i){

            output *= dp[np.get(i)][kp.get(i)];
            output %= m;
        }

        System.out.println(output);
    }
}
