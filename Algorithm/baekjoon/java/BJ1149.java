package baekjoon.java;

import java.util.*;
import static java.lang.Math.min;

public class BJ1149 {

    public static Scanner scanner = new Scanner(System.in);

    public static final int R = 0;
    public static final int G = 1;
    public static final int B = 2;

    public static void main(String[] args){
        int number = scanner.nextInt();

        int[][] color = new int[number+1][3];
        for(int i = 1; i <= number; ++i){
            color[i][R] = scanner.nextInt();
            color[i][G] = scanner.nextInt();
            color[i][B] = scanner.nextInt();
        }

        int output = calDP(number, color);
        System.out.println(output);

    }

    private static int calDP(int number, int[][]color) {
        int[][] DP = new int[number+1][3];

        for(int i = 1; i <= number; ++i){
            DP[i][R] = color[i][R] + min(DP[i-1][G], DP[i-1][B]);
            DP[i][G] = color[i][G] + min(DP[i-1][R], DP[i-1][B]);
            DP[i][B] = color[i][B] + min(DP[i-1][R], DP[i-1][G]);
        }

        return  min(DP[number][R], min(DP[number][G], DP[number][B]));
    }
}
