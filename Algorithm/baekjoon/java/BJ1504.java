package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 1. 4..
 */
public class BJ1504 {
    public static final int inf = 1000000000;

    public static int[] dijkstra(int n, int[][] graph, int start){
        //dist는 시작점 부터의 각 정점 까지의 최단 거리를 구한다.
        int[] dist = new int[n + 1];
        boolean[] check = new boolean[n + 1];
        for(int i = 1; i <= n; ++i){
            dist[i] = inf;
            check[i] = false;
        }
        dist[start] = 0;
        for(int k = 0; k < n - 1; ++k){
            int min = inf + 1;
            int x = -1;
            for(int i = 1; i <= n; ++i){
                if(check[i] == false && min > dist[i]){
                    min = dist[i];
                    x = i;
                }
            }
            check[x] = true;
            for(int i = 1; i <= n; ++i){
                if(dist[i] > dist[x] + graph[x][i]){
                    dist[i] = dist[x] + graph[x][i];
                }
            }
        }
        return dist;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= n; ++j){
                graph[i][j] = inf;
            }
        }

        for(int i = 0; i < e; ++i){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();

            if(graph[start][end] > cost) {
                graph[start][end] = cost;
            }
            if(graph[end][start] > cost){
                graph[end][start] = cost;
            }
        }

        int vertex1 = sc.nextInt();
        int vertex2 = sc.nextInt();

        int startDist[] = dijkstra(n, graph, 1);
        int v1Dist[] = dijkstra(n, graph, vertex1);
        int v2Dist[] = dijkstra(n, graph, vertex2);

        int output = startDist[vertex1] + v1Dist[vertex2] + v2Dist[n];
        int output2 = startDist[vertex2] + v2Dist[vertex1] + v1Dist[n];

        if(output > output2) output = output2;
        if(output >= inf) output = -1;

        System.out.println(output);
    }
}
