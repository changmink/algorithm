package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 3..
 */
import java.util.*;
class Edge{
    int to, cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
public class BJ1948 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge>[] a = new List[n+1];//원래 방향
        List<Edge>[] ar = new List[n+1];//반대 방향
        for(int i = 1; i <= n; ++i){
            a[i] = new ArrayList<>();
            ar[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; ++i){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            a[from].add(new Edge(to, cost));
            ar[to].add(new Edge(from, cost));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        //마지막까지 도착하는시간 - 최장 거리 찾기
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n + 1];
        int[] dist = new int[n + 1];
        for(int i = 1; i <= n; ++i){
            for(Edge e : a[i]){
                indegree[e.to] += 1;
            }
        }
        q.add(start);
        while(!q.isEmpty()){
            int from = q.remove();
            for(Edge e : a[from]){
                int to = e.to;
                int cost = e.cost;
                if(dist[to] < dist[from] + cost){
                    dist[to] = dist[from] + cost;
                }

                indegree[to] -= 1;
                if(indegree[to] == 0){
                    q.add(to);
                }
            }
        }
        System.out.println(dist[end]);

        //쉬지 않고 달리는 도로의 수. 경로를 거꾸로 찾아가면서 카운트한다.
        for(int i=1; i <=n; ++i){
            indegree[i] = 0;
        }
        for (int i = 1; i <= n; ++i){
            for(Edge e : ar[i]){
                indegree[e.to] += 1;
            }
        }
        boolean[] check = new boolean[n + 1];
        q.add(end);
        check[end] = true;
        int output = 0;
        while(!q.isEmpty()){
            int from = q.remove();
            for(Edge e : ar[from]){
                int to = e.to;
                int cost = e.cost;
                if(dist[from] - dist[to] == cost){
                    if(check[from]){
                        output += 1;
                        check[to] = true;
                    }
                }
                indegree[to] -= 1;
                if(indegree[to] == 0){
                    q.add(to);
                }
            }
        }
        System.out.println(output);


    }
}
