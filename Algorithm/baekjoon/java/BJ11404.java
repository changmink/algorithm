package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 4..
 */
import java.util.*;
public class BJ11404 {
    public static final int inf = 100000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input[][] = new int[n + 1][n + 1];
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= n; ++j){
                if(i == j){
                    input[i][j] = 0;
                }else {
                    input[i][j] = inf;
                }
            }
        }
        int m = sc.nextInt();
        for(int i = 0; i < m; ++i){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            if(input[from][to] > cost){
                input[from][to] = cost;
            }
        }

        for(int k = 1; k <= n; ++k) {
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if(input[i][j] > input[i][k] + input[k][j]){
                        input[i][j] = input[i][k] + input[k][j];
                    }
                }
            }
        }

        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= n; ++j){
                if(input[i][j] == inf) System.out.print('0');
                else System.out.print(input[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
