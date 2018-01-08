package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 1. 4..
 */
public class BJ1916List {
    static class Edge{
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    static final int inf = 1000000000;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Edge>[] a = new List[n+1];
        for(int i = 1; i <= n; ++i){
            a[i] = new ArrayList<>();
        }

        int m = sc.nextInt();
        for(int i = 0; i < m; ++i){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            a[from].add(new Edge(to, cost));
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

        for(int k = 0; k < n - 1; ++k){
            int min = inf + 1;
            int x = -1;
            for(int i = 1; i <= n; ++i){
                if(c[i] == false && min > d[i]) {
                    min = d[i];
                    x = i;
                }
            }
            c[x] = true;
            for(Edge y : a[x]){
                if(d[y.to] > d[x] + y.cost){
                    d[y.to] = d[x] + y.cost;
                }
            }
        }
        System.out.println(d[end]);
    }
}

