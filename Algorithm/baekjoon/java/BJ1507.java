package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 5..
 */

import java.util.*;
public class BJ1507 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n][n];
        boolean[][] unused = new boolean[n][n];
        for(int i = 0; i < n ; ++i){
            for(int j = 0; j < n; ++j){
                d[i][j] = sc.nextInt();
            }
        }

        for(int k = 0; k < n; ++k){
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < n; ++j){
                    if(i == j) continue;
                    if(k == j) continue;
                    if(d[i][j] > d[i][k] + d[k][j]){
                        System.out.println(-1);
                        System.exit(0);
                    }
                    if(d[i][j] == d[i][k] + d[k][j]){
                        unused[i][j] = true;
                    }
                }
            }
        }

        int output = 0;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(unused[i][j] == false){
                    output += d[i][j];
                }
            }
        }

        output /= 2;
        System.out.println(output);
    }
}
