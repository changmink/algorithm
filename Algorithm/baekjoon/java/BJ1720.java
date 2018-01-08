package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 1. 1..
 */
import java.util.*;
public class BJ1720 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //대칭 포함해서 구하기 - dp1에서는 대칭이 아닌 것은 2개씩 대칭인것은 1개씩 구해진다.
        long[] dp1 = new long[31];
        dp1[1] = 1;
        dp1[2] = 3;
        for(int i = 3; i <= 30; ++i){
            dp1[i] = dp1[i-1] + dp1[i-2] * 2;
        }

        //대칭 없이 구하기
        long[] dp2 = new long[31];
        dp2[1] = 1;
        dp2[2] = 3;
        //대칭만 따져본다.
        for(int i = 3; i <= 30; ++i){
            long b = 0;
            if(i % 2 == 1){
                b = dp1[(i - 1) / 2];//가운데 1*2만 있는 대칭
            }else{
                b = dp1[i / 2] + 2 * dp1[(i - 2)/2];// 가운데 2*2 혹은 없는 대칭
            }
            //반으로
            dp2[i] = (dp1[i] + b) / 2;
        }

        System.out.println();
    }
}
