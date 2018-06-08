package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 3. 9..
 */
public class BJ1260 {
    public static String dfs(List<Integer>[] graph, int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        boolean[] visited = new boolean[graph.length];
        visited[0] = visited[start] = true;
        StringBuilder output = new StringBuilder();
        output.append(start);
        output.append(" ");

        whileLoop:
        while(!stack.isEmpty()){
            for(int vertex : graph[stack.peek()]) {
                if (visited[vertex] == false){
                    stack.push(vertex);
                    visited[vertex] = true;
                    output.append(vertex);
                    output.append(" ");
                    continue whileLoop;
                }

            }
            stack.pop();
        }

        return output.toString();
    }

    public static String bfs(List<Integer>[] graph, int start){
        //큐를 이용한다.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean visited[] = new boolean[graph.length];
        visited[0] = visited[start] = true;
        StringBuilder output = new StringBuilder();
        output.append(start);
        output.append(" ");

        while(!queue.isEmpty()){
            int vertex = queue.poll();

            for(int v : graph[vertex]){
                if(visited[v] == false) {
                    queue.offer(v);
                    visited[v] = true;
                    output.append(v);
                    output.append(" ");
                }
            }
        }

        return output.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        List<Integer> graph[] = new List[n+1];
        for(int i = 1; i <= n; ++i){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; ++i){
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph[from].add(to);
            graph[to].add(from);
        }

        //"단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고"
        for(int i = 1; i <= n; ++i){
            Collections.sort(graph[i]);
        }

        System.out.println(dfs(graph, start));
        System.out.println(bfs(graph, start));
    }
}
