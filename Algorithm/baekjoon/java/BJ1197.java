package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 3..
 */
import java.util.*;
public class BJ1197 {
    static class Edge{
        public int start;
        public int end;
        public int cost;

        public Edge() {
            this(0, 0, 0);
        }

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[n + 1];
        for(int i = 0; i <= n; ++i){
            p[i] = i;
        }

        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i <m; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(start, end, cost));
        }
        //간선 정렬
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.cost, o2.cost);
            }
        });
        int output = 0;
        for(Edge e : edges){
            //각각 집합의 루트를 가져와서 비교
            int x = find(p, e.start);
            int y = find(p, e.end);
            if(x != y){//간선이 다른 집합인가?
                disjointUnion(p, e.start, e.end);
                output += e.cost;
            }
        }
        System.out.println(output);
    }
    public static void disjointUnion(int[] p, int x, int y){
        x = find(p, x);
        y = find(p, y);
        p[x] = y;
    }

    private static int find(int[] p, int x) {
        if(x == p[x]){
            return x;
        }else{
            return (p[x] = find(p, p[x]));
        }
    }
}
