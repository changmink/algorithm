package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 1..
 */
import java.util.*;
public class BJ2240 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int t = scanner.nextInt();
        int w = scanner.nextInt();
        int input[] = new int[t+1];
        int[][] dp = new int[t+1][w+1];

        for(int i = 1; i <= t; ++i){
            input[i] = scanner.nextInt();
        }

        for(int i = 0; i <= t; ++i){
            Arrays.fill(dp[i], -1);
        }

        int output = Math.max(go(input, dp, 1, 1, t, w),
                go(input, dp, 1, 0, t, w));

        System.out.println(output);
    }

    private static int go(int[] input, int[][] dp, int time, int turn, int t, int w) {
        if(time == t + 1 && turn <= w){
            return 0;
        }
        if(turn > w) return 0;

        if(dp[time][turn] != -1) return dp[time][turn];

        int where = turn % 2 + 1;
        dp[time][turn] = Math.max(go(input, dp, time + 1, turn, t, w),
                                go(input, dp, time + 1, turn + 1, t, w))
                        + (where == input[time]? 1 : 0);//자두가 있으면 받음
        return dp[time][turn];
    }
}
