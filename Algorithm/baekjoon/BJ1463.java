package baekjoon;

import java.util.*;

public class BJ1463 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int n = scanner.nextInt();
        int[] DP = new int[n+1];

        for(int i = 2; i <= n; ++i){
            DP[i] = DP[i - 1] + 1;

            if(i % 2 == 0){
                DP[i] = Math.min(DP[i], DP[i / 2] + 1);
            }

            if(i % 3 == 0){
                DP[i] = Math.min(DP[i], DP[i / 3] + 1);
            }
        }

        System.out.println(DP[n]);
    }
}
