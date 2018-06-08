package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 3. 11..
 */
public class BJ1707 {
    public static boolean bipartiteGraph = true;
    public static void dfs(int visited[], List<Integer>[] graph, int start, int color){
        visited[start] = color;
        for(int vertex : graph[start]){
            if(visited[vertex] == color){
                bipartiteGraph = false;
            }
            else if(0 == visited[vertex]) {
                dfs(visited, graph, vertex, color % 2 + 1);
            }
        }
    }
    public static void countDFS(int[] visited, List<Integer>[] graph){

        for(int i = 1; i < graph.length; ++i) {
            if(visited[i] == 0) {
                dfs(visited, graph, i, 1);
            }
        }
    }

    public static void checkVertex(int[] visited){
        for(int i = 1; i < visited.length; ++i){
            if(visited[i] == 0) {
                bipartiteGraph = true;
                return;
            }
        }
        return;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 0; t < tc; ++t) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            List<Integer>[] graph = new List[v + 1];
            for (int i = 1; i <= v; ++i) {
                graph[i] = new ArrayList<>();
            }
            int begin = 0;
            int end = 0;
            for (int i = 0; i < e; ++i) {
                begin = sc.nextInt();
                end = sc.nextInt();
                graph[begin].add(end);
                graph[end].add(begin);
            }
            int[] visited = new int[graph.length];
            visited[0] = -1;
            bipartiteGraph = true;
            countDFS(visited, graph);
            checkVertex(visited);
            if (bipartiteGraph) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
