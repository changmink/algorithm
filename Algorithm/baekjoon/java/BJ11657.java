package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 1. 4..
 */
public class BJ11657 {
    static class Edge{
        public int from;
        public int to;
        public int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

    }
    public static final int inf = 100000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t;
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Edge> a = new ArrayList<>();
        for(int i = 0; i < m; ++i){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            a.add(new Edge(from, to, cost));
        }
        int[] dist = new int[n + 1];
        for(int i = 1; i <= n; ++i){
            dist[i] = inf;
        }
        //시작 위치
        dist[1] = 0;
        boolean negativeCycle = false;
        //
        for(int i = 1; i <= n; ++i){
            for(int j = 0; j < m; ++j){
                int from = a.get(j).from;
                int to = a.get(j).to;
                int cost = a.get(j).cost;
                if(dist[from] != inf //아직 최단 거리를 구하지 않은 경우에는 넘어 가야한다.
                        && dist[to] > dist[from] + cost){
                    dist[to] = dist[from] + cost;
                    if(i == n){//한번 더 점검 하고 바뀐다면
                        negativeCycle = true;
                    }
                }
            }
        }

        if(negativeCycle) System.out.println("-1");
        else {
            for(int i = 2; i <= n; ++i){
                if(dist[i] == inf) dist[i] = -1;
                System.out.println(dist[i]);
            }
        }
    }
}
