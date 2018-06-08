package baekjoon.java;

import java.util.*;

public class BJ11724 {
    static void BFS(boolean[] checked, List<Integer>[] graph, int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        checked[start] = true;
        while(!queue.isEmpty()){
            int vertex = queue.poll();

            for(int v : graph[vertex]){
                if(!checked[v]){
                    queue.offer(v);
                    checked[v] = true;
                }
            }
        }
    }

    static int countBFS(boolean[] checked, List<Integer>[] graph){
        int count = 0;
        for(int i = 1; i < checked.length; ++i){
            if(!checked[i]) {
                BFS(checked, graph, i);
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer>[] graph = new List[n+1];

        for(int i = 1; i <= n; ++i){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; ++i){
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph[start].add(end);
            graph[end].add(start);
        }

        boolean[] checked = new boolean[n+1];
        checked[0] = true;

        int output = countBFS(checked, graph);
        System.out.println(output);
    }
}
