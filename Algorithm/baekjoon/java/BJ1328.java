package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 1..
 */
import java.util.*;
public class BJ1328 {
    public static Scanner sc = new Scanner(System.in);
    public static long dp[][][] = new long[101][101][101];
    public static final long MOD = 1000000007;
    public static void main(String[] args){
        int n, l, r;
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        dp[1][1][1] = 1;
        method2(n, l, r);
        System.out.print(dp[n][l][r]);

    }

    private static void method1(int n, int l, int r) {
        //1 ~ n-1에서 하나를 추가한다고 생각
        for(int i=1; i <= n - 1; ++i){
            for(int j=1; j <= l; ++j){
                for(int k=1; k <= r; ++k){
                    //왼쪽끝에 추가
                    if(j + 1 <= l ){
                        dp[i+1][j+1][k] += dp[i][j][k];
                        dp[i+1][j+1][k] %= MOD;
                    }
                    //오른쪽끝에 추가
                    if(k + 1 <= r){
                        dp[i+1][j][k+1] += dp[i][j][k];
                        dp[i+1][j][k+1] %= MOD;
                    }
                    //나머지에 추가
                    dp[i+1][j][k] += dp[i][j][k] * (i - 1);
                    dp[i+1][j][k] %= MOD;
                }
            }
        }
    }

    private static void method2(int n, int l, int r) {
        //빌딩 1이 어딨는지 1뺀것들을 더한다.
        for(int i=2; i <= n; ++i){
            for(int j=1; j <= l; ++j){
                for(int k=1; k <= r; ++k){
                    dp[i][j][k] = dp[i-1][j-1][k] //왼쪽에 빌딩 1
                            + dp[i-1][j][k-1]  // 오른쪽에 빌딩 1
                            + dp[i-1][j][k] * (i - 2); //사이에 빌딩 1 - 총 i개 경우중 오른쪽 왼쪽을 뺀다.
                    dp[i][j][k] %= MOD;
                }
            }
        }
    }
}
