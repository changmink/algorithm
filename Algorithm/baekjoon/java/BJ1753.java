package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 4..
 */
import java.util.*;
public class BJ1753 {
    static class Edge{
        public int to;
        public int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    //Pair보다는 Vertex가 나으려나
    static class Pair implements Comparable{
        public int x;
        public int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            Pair p = (Pair)o;
            return Integer.compare(this.x, p.x);
        }
    }

    public static final int inf = 1000000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        List<Edge>[] a = new List[n+1];
        for(int i = 1; i <= n; ++i){
            a[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; ++i){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            a[from].add(new Edge(to, cost));
        }
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        for(int i = 1; i <= n; ++i){
            dist[i] = inf;
        }

        dist[start] = 0;
        Queue<Pair> q = new PriorityQueue<>();
        q.offer(new Pair(0, start));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.y;
            if(check[x]){
                continue;
            }
            check[x] = true;
            for(int i = 0; i < a[x].size(); ++i){
                int y = a[x].get(i).to;
                if(dist[y] > dist[x] + a[x].get(i).cost){
                    dist[y] = dist[x] + a[x].get(i).cost;
                    //맥스 힙이 기본이기 때문에 최소힙으로 사용하려고 이렇게 함
                    q.offer(new Pair(-dist[y], y));
                }
            }

        }
        for(int i = 1; i <= n; ++i){
            if(dist[i] >= inf){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
    }
}
