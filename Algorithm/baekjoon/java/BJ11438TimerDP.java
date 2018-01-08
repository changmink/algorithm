package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 1. 6..
 */
public class BJ11438TimerDP {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Integer>();
        }

        for (int i=1; i<=n-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x].add(y);
            a[y].add(x);
        }
        for(l=1; (1<<l) <= n; ++l);
        l -= 1;
        dfs(1, 1);
        int m = sc.nextInt();
        while(m-- > 0){
            int u = sc.nextInt();
            int v = sc.nextInt();
            System.out.println(lca(p, u, v));
        }

    }


    public static int l = 0;
    public static final int MAX = 100111;
    static int tin[] = new int[MAX];
    static int tout[] = new int[MAX];
    static int p[][] = new int[MAX][18];
    static int timer = 0;
    static List<Integer>[] a = new List[MAX];

    public static boolean upper(int u, int v){
        return (tin[u] <= tin[v] && tout[u] >= tout[v]);
    }

    public static int lca(int[][]p, int u, int v){
        if(upper(u, v)) return u;
        if(upper(v, u)) return v;
        for(int i = l; i >= 0; --i){
            if(!upper(p[u][i], v)){
                u = p[u][i];
            }
        }
        return p[u][0];
    }

    public static void dfs(int v, int parent){
        tin[v] = ++timer;
        p[v][0] = parent;
        for(int i = 1; i <=l; ++i){
            p[v][i] = p[p[v][i-1]][i-1];
        }
        for(int to : a[v]){
            if(to != parent){
                dfs(to, v);
            }
        }
        tout[v] = ++timer;
    }
}
