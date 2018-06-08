package baekjoon.java;

import java.util.*;

/**
 * 나중에 다시 풀어라
 */

public class BJ9466 {
    public static int count = 0;
    public static void dfs(boolean[] visited, boolean[] finished, int[] graph, int start){
        visited[start] = true;
        int next = graph[start];
        if(visited[next]){
           if(!finished[next]){
               for(int temp = next; temp != start; temp=graph[temp]) count += 1;
               count += 1;
           }else ;
        }else{
            dfs(visited, finished, graph, next);
        }
        finished[start] = true;
    }

    public static void countCycle(int[] graph){
        boolean[] visited = new boolean[graph.length];
        boolean[] finished= new boolean[graph.length];
        for(int i = 1; i < graph.length; ++i){
            if(visited[i] == false){
                dfs(visited, finished, graph, i);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        while(testcase-- > 0) {
            count = 0;
            int n = sc.nextInt();
            int[] graph = new int[n+1];

            for (int i = 1; i < graph.length; ++i) {
                graph[i] = sc.nextInt();
            }

            countCycle(graph);

            System.out.println(n - count);
        }
    }
}
