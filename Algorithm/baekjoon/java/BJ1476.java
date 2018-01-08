package baekjoon.java;

import java.util.*;

/**
 * 브루트 포스
 */
public class BJ1476 {
    public static int getYear(int E, int S, int M){

        int e = 1;
        int s = 1;
        int m = 1;
        //for루프로 증가
        for(int i = 1; ; ++i){ // 15 * 28 * 19가 거의 최대 만 이천 정도이다
            if(e == E && s == S && m == M)
                return i;
            e++;
            s++;
            m++;

            if(e > 15) e = 1;
            if(s > 28) s = 1;
            if(m > 19) m = 1;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int E = scanner.nextInt();
        int S = scanner.nextInt();
        int M = scanner.nextInt();
        int output = getYear(E, S, M);
        System.out.println(output);
    }
}
