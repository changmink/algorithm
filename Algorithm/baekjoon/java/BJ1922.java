package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 3..
 */
import java.util.*;

public class BJ1922 {
    static class Edge{
        public int start;
        public int end;
        public int cost;

        public Edge(){
            this(0, 0 ,0);
        }

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Edge>[] a = new List[n+1];
        for(int i = 1; i <= n; ++i){
            a[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; ++i){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            //방향이 없으므로 양방향으로 해준다.
            a[start].add(new Edge(start, end, cost));
            a[end].add(new Edge(end, start, cost));
        }

        //힙 사용하기 우선순위 큐가 민힙이다.
        boolean[] check = new boolean[n + 1];
        Queue<Edge> q = new PriorityQueue<>(1, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.cost, o2.cost);
            }
        });

        //첫 번째 선택
        check[1] = true;
        for(Edge e : a[1]){//과 연결된 것을 다 힙에 넣는다
            q.add(e);
        }


        int output = 0;
        for(int i = 0; i < n-1; ++i){//1은 이미 선택함
            Edge e = new Edge();
            while(!q.isEmpty()){
                e = q.poll();
                if(check[e.end] == false){
                    break;
                }
            }
            //끝점과 다시 연결
            check[e.end] = true;
            output += e.cost;
            for(Edge ee : a[e.end]){
                q.add(ee);
            }
        }

        System.out.println(output);
    }
}
