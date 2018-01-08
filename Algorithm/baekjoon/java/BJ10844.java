package baekjoon.java;

import java.util.*;

public class BJ10844 {
    public static Scanner scanner = new Scanner(System.in);
    public static final long MOD = 1000000000;

    public static void main(String[] args){
        int n = scanner.nextInt();
        long output = 0;
        if(n == 1){
            output = 9;
        }
        else {
            long[][] DP = new long[n + 1][11];

            for (int i = 1; i <= 9; ++i) {
                DP[1][i] = 1;
            }

            for (int row = 2; row <= n; ++row) {
                for (int col = 0; col <= 9; ++col) {
                    if(col == 0)
                        DP[row][col] = DP[row-1][1] % MOD;
                    else
                        DP[row][col] = (DP[row - 1][col - 1] + DP[row - 1][col + 1]) % MOD;
                }
            }

            for (int col = 0; col <= 9; ++col) {
                output += DP[n][col];
            }
        }

        System.out.println(output % MOD);
    }
}
