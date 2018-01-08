package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 28..
 */
import java.util.*;
public class BJ1509 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        String input = scanner.nextLine().trim();
        int n = input.length();
        input = " " + input;

        //인덱스 1부터 사용하기 위해 n+1
        boolean[][] check = new boolean[n+1][n+1];
        for(int i = 1; i <= n; ++i){
            check[i][i] = true;
        }

        for(int i =1; i <= n - 1; ++i){
            if(input.charAt(i) == input.charAt(i+1)){
                check[i][i+1] = true;
            }
        }
        //k는 최대 인덱스
        for(int k=2; k < n; ++k){
            for(int i = 1; i <= n - k; ++i){
                int j = i + k;
                if(input.charAt(i) == input.charAt(j)
                        && check[i+1][j-1]) {
                    check[i][j] = true;
                }
            }
        }

        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; ++i){
            dp[i] = -1;
            for(int j = 1; j <= i; ++j){
                if(check[j][i]){
                    if(dp[i] == -1
                            || dp[i] > dp[j-1] + 1){//더 크면 작은 거로 갱신한다.
                        dp[i] = dp[j-1] + 1;
                    }
                }
            }
        }

        System.out.println(dp[n]);
    }
}
