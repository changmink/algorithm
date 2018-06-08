package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 3. 12..
 */
public class BJ10451 {
    public static boolean cycle = false;
    public static void DFS(boolean[] visited, List<Integer>[] graph, int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        whileLoop:
        while(!stack.empty()){
            for(int v : graph[stack.peek()]){
                if(v == start){
                    cycle = true;
                    return;
                }
                if(visited[v] == false){
                    visited[v] = true;
                    stack.push(v);
                    continue whileLoop;
                }
            }
            stack.pop();
        }
    }

    public static int countCycle(List<Integer>[] graph){
        boolean[] visited = new boolean[graph.length];
        int count = 0;
        for(int i = 1; i < graph.length; ++i){
            if(visited[i] == false) {
                cycle = false;
                DFS(visited, graph, i);
                if (cycle) count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int testcase = 0; testcase < t; ++testcase){
            int n  = sc.nextInt();
            List<Integer>[] graph = new List[n+1];
            for(int node = 1; node <= n; ++node){
                graph[node] = new ArrayList<>();
            }

            for(int start = 1; start <= n; ++start){
                int end = sc.nextInt();
                graph[start].add(end);
            }

            System.out.println(countCycle(graph));
        }

    }
}
