package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 5..
 */
import java.util.*;
public class BJ1389 {
    public static final int inf = 1000000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] input = new int[n + 1][n + 1];
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= n; ++j){
                if(i == j) input[i][j] = 0;
                else input[i][j] = inf;
            }
        }

        for(int i = 0; i < m; ++i){
            int from = sc.nextInt();
            int to = sc.nextInt();
            //무 방향
            input[from][to] = input[to][from] = 1;
        }

        for(int k = 1; k <= n; ++k){
            for(int i = 1; i <= n; ++i){
                for(int j = 1; j <= n; ++j){
                    if(input[i][j] > input[i][k] + input[k][j]){
                        input[i][j] = input[i][k] + input[k][j];
                    }
                }
            }
        }

        int ans = -1;
        int who = -1;
        for(int i = 1; i <= n; ++i){
            int sum = 0;
            for(int j = 1; j <= n; ++j){
                if(i == j) continue;
                sum += input[i][j];
            }
            if(ans == -1 || sum < ans){
                ans = sum;
                who = i;
            }
        }

        System.out.println(who);



    }
}
