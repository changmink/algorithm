package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 4..
 */
import java.util.*;
public class BJ1865 {
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

    public static final int inf = 2500 * 10000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int w = sc.nextInt();
            List<Edge> graph = new ArrayList<>();
            for(int i = 0; i < m; ++i){
                int from = sc.nextInt();
                int to = sc.nextInt();
                int cost = sc.nextInt();
                graph.add(new Edge(from, to, cost));
                graph.add(new Edge(to, from, cost));
            }

            for(int i = 0; i < w; ++i){
                int from = sc.nextInt();
                int to = sc.nextInt();
                int cost = sc.nextInt();
                graph.add(new Edge(from, to, -cost));
            }

            int[] dist = new int[n + 1];
            for(int i = 1; i <= n; ++i){
                dist[i] = inf;
            }
            dist[1] = 0;

            boolean isTimeback = false;
            for(int i = 1; i <= n; ++i){
                for(Edge e : graph) {
                    int from = e.from;
                    int to = e.to;
                    int cost = e.cost;
                    if (dist[from] != inf && dist[to] > dist[from] + cost) {
                        dist[to] = dist[from] + cost;
                        if (i == n) {
                            isTimeback = true;
                        }
                    }
                }
            }

            if(isTimeback) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
