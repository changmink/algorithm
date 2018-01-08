package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 1. 6..
 */
public class BJ11659 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int signal[] = new int[n+1];
        for(int i = 1 ; i <= n; ++i){
            signal[i] = sc.nextInt();
            signal[i] += signal[i-1];
        }

        for(int i = 0; i < m; ++i){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int output = signal[end] - signal[start-1];
            System.out.println(output);
        }



    }
}
