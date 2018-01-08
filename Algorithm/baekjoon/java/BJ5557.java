package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 2..
 */
import java.util.*;
public class BJ5557 {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        //마지막 수는 등호 이후 숫자 이므로 따로 받는다.
        for(int i = 0; i < n-1; ++i){
            numbers[i] = scanner.nextInt();
        }
        int goal = scanner.nextInt();

        int[][] dp = new int[n+1][21];
        //첫번째를 초기화
        dp[0][numbers[0]] = 1;

        for(int i = 1; i < n-1; ++i){
            for(int j = 0; j <= 20; ++j){
                if(j + numbers[i] <= 20)
                    dp[i][j] += dp[i-1][j + numbers[i]];
                if(j - numbers[i] >= 0)
                    dp[i][j] += dp[i-1][j - numbers[i]];
            }
        }
        //마지막 i는 n-2
        System.out.println(dp[n-2][goal]);
    }
}
