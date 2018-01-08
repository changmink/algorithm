package baekjoon.java;

import sun.jvm.hotspot.memory.*;

import java.util.*;

/**
 * Created by changmin on 2018. 1. 5..
 */
public class BJ11657SPFA {
    static class Edge{
        int to, cost;
        public Edge(){

        }
        public Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    public static final int inf = 1000000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] d = new int[n + 1];
        boolean[] c = new boolean[n + 1];
        int[] cnt = new int[n + 1];
        List<Edge>[] a = new List[n+1];

        for(int i = 1; i <= n; ++i){
            a[i] = new ArrayList<>();
            d[i] = inf;
        }

        for(int i = 0; i < m; ++i){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            a[from].add(new Edge(to, cost));
        }

        d[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        c[1] = true;

        while(!q.isEmpty()){
            int from = q.poll();
            c[from] = false;
            for(Edge e : a[from]){
                int to = e.to;
                int cost = e.cost;
                if(d[to] > d[from] + cost){
                    d[to] = d[from] + cost;
                    if(c[to] == false){
                        q.offer(to);
                        c[to] = true;
                        cnt[to] += 1;
                        if(cnt[to] >= n){
                            System.out.println("-1");
                            System.exit(0);
                        }
                    }
                }
            }
        }

        for(int i = 2; i <= n; ++i){
            if(d[i] == inf){
                System.out.println("-1\n");
            } else{
                System.out.println(d[i]);
            }
        }

    }
}
