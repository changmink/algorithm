package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 4..
 */
import java.util.*;
public class BJ1916Array {
    static final int inf = 1000000000;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n + 1][n + 1];
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= n; ++j){
                a[i][j] = inf;
            }
        }

        for(int i = 0; i < m; ++i){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            if(a[from][to] > cost){
                a[from][to] = cost;
            }
        }

        int start = sc.nextInt();
        int end = sc.nextInt();
        int[] d = new int[n + 1];
        boolean[] c = new boolean[n + 1];
        for(int i = 1; i <= n; ++i){
            d[i] = inf;
            c[i] = false;
        }

        d[start] = 0;
        for(int k = 0; k < n-1; ++k){
            int min = inf + 1;
            int x = -1;
            //선택이 되어 있지 않고 최소값보다 작은 값이면 갱신
            for(int i = 1; i <= n; ++i){
                if(c[i] == false && min > d[i]){
                    min = d[i];
                    x = i;
                }
            }
            c[x] = true;
            for(int i = 1; i <= n; ++i){
                if(d[i] > d[x] + a[x][i]){
                    d[i] = d[x] + a[x][i];
                }
            }
        }

        System.out.println(d[end]);
    }
}
