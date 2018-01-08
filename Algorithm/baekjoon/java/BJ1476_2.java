package baekjoon.java;

import java.util.*;

/**
 * 중국인의 나머지 정리를 이용
 */
public class BJ1476_2 {
    public static int getYear(int E, int S, int M){
        /**
         * (28 * 19 * E) % 15 == (15 * 19 * S) % 28 == (15 * 28 * M) % 19 == 1
         * (532 * E) % 15 == (285 * S) % 28 == (420 * M) % 19 == 1
         * (7 * E) % 15 == (5 * S) % 28 == (2 * M) % 19 == 1
         * E = 13, S = 17, M = 10
         */
        return (E * 6916 + S * 4845 + M * 4200) % 7890;
    }
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        int e = scanner.nextInt();
        int s = scanner.nextInt();
        int m = scanner.nextInt();

        int output = getYear(e, s, m);
        System.out.println(output);
    }
}
