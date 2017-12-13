package baekjoon;

import java.util.*;

class BJ11048{
    public static long[][] DP = new long[1001][1001];
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){

    int N = scan.nextInt();
    int M = scan.nextInt();
    long[][] input = new long[N + 1][M + 1];

        for(int i = 1; i <= N; ++i){
        for(int j = 1; j <= M; ++j){
            input[i][j] = scan.nextLong();
        }
    }

        System.out.println(solution(input));
}
    public static long solution(long[][] input){

        for(int i = 1; i < input.length; ++i){
            for(int j = 1; j < input[0].length; ++j){
                DP[i][j] = input[i][j] + Math.max(DP[i-1][j-1], Math.max(DP[i-1][j], DP[i][j-1]));
            }
        }

        return DP[input.length-1][input[0].length-1];
    }
}
