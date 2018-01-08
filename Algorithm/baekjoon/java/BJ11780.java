package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 5..
 */
import java.util.*;
public class BJ11780 {
    public static final int inf = 1000000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] input = new int[n + 1][n + 1];
        int[][] next = new int[n + 1][n + 1];

        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= n; ++j){
                if(i == j){
                    input[i][j] = 0;
                }else {
                    input[i][j] = inf;
                }
                next[i][j] = -1;
            }
        }
        for(int i = 0; i < m; ++i){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cast = sc.nextInt();
            if(input[from][to] > cast) {
                input[from][to] = cast;
                next[from][to] = to;
            }
        }

        for(int k = 1; k <= n; ++k){
            for(int i = 1; i <= n; ++i){
                for(int j = 1; j <= n; ++j){
                    if(input[i][j] > input[i][k] + input[k][j]){
                        input[i][j] = input[i][k] + input[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= n; ++j){
                if(input[i][j] == inf) System.out.print('0');
                else System.out.print(input[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= n; ++j){
                if(input[i][j] == inf || i == j)System.out.println('0');
                else path(next, i, j);
            }
        }


    }

    private static void path(int[][] next, int i, int j) {
        if(next[i][j] == -1){
            System.out.println("0");
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        while(i != j){
            i = next[i][j];
            q.offer(i);
        }
        System.out.print(q.size() + " ");
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}
