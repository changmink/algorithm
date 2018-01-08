package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 1. 4..
 */

public class BJ11779 {
    static class Edge{
        public int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static final int inf = 1000000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Edge>[] graph = new List[n+1];
        for(int i = 1; i <= n; ++i){
            graph[i] = new ArrayList<>();
        }

        int m = sc.nextInt();
        for(int i = 0; i < m; ++i){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            graph[from].add(new Edge(to, cost));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();
        int[] dist = new int[n + 1];
        boolean[] check = new boolean[n + 1];
        for(int i = 1; i <= n; ++i){
            dist[i] = inf;
            check[i] = false;
        }


        int[] path = new int[n+1];

        dist[start] = 0;
        //시작 위치 표시
        path[start] = -1;

        for(int k = 0; k < n - 1; ++k){
            int min = inf + 1;
            int x = -1;
            for(int i = 1; i <= n; ++i){
                if(check[i] == false && min > dist[i]) {
                    min = dist[i];
                    x = i;
                }
            }
            check[x] = true;

            for(Edge y: graph[x]){
                if(dist[y.to] > dist[x] + y.cost){
                    dist[y.to] = dist[x] + y.cost;
                    path[y.to] = x;
                }
            }
        }

        System.out.println(dist[end]);

        Stack<Integer> stack = new Stack<>();
        int x = end;
        while(x != -1){
            stack.push(x);
            x = path[x];
        }
        System.out.println(stack.size());

        while(!stack.empty()){
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
        System.out.println();
    }
}
