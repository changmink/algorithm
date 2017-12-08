package backjoon;

import java.util.*;

public class BJ2579 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int n = scanner.nextInt();
        int[] input = new int[n];
        int[] DP = new int[n];
        int output = 0;
        for(int i = 0; i < n; ++i){
            input[i] = scanner.nextInt();
        }

        DP[0] = input[0];
        DP[1] = Math.max(input[0] + input[1], input[1]);
        DP[2] = Math.max(input[0] + input[2], input[1] + input[2]);
        for(int i = 3; i < n; ++i){
           DP[i] = Math.max(input[i] + DP[i-2], input[i] + input[i-1] + DP[i-3]);
        }
        System.out.println(DP[n-1]);
    }

}
