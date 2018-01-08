package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 31..
 */
import java.util.*;
import java.io.*;

public class BJ11066 {
    public static void main(String args[]) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.valueOf(bf.readLine());
        while(testcase-- > 0){
            int n = Integer.valueOf(bf.readLine());
            String[] nums = bf.readLine().split(" ");
            int[] input = new int[n+1];
            //i까지의 합
            int[] sum = new int[n+1];
            int[][] dp = new int[n+1][n+1];

            for(int i = 1; i <= n; ++i){
                input[i] = Integer.valueOf(nums[i-1]);
                sum[i] = sum[i-1] + input[i];
                Arrays.fill(dp[i], -1);
            }
            int output = go(input, sum, dp, 1, n);
            System.out.println(output);
        }
    }

    private static int go(int[] input, int[] sum, int[][] dp, int i, int j) {
        if(i == j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int output = -1;
        //k로 분리
        for(int k = i; k <= j-1; ++k){
            int temp = go(input, sum, dp, i, k) + go(input, sum, dp, k+1, j)
                    + sum[j] - sum[i-1];//실질적으로 더하는 것은 이 부분
            if(output == -1 || output > temp){
                output = temp;
            }
        }

        return output;
    }
}
