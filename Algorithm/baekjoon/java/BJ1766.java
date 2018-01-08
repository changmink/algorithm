package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 3..
 */
import java.util.*;
public class BJ1766 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer>[] DAG = new List[n+1];
        int[] indegrees = new int[n+1];

        for(int i = 1; i <= n; ++i){
            DAG[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; ++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            DAG[a].add(b);
            indegrees[b] += 1;
        }

        Queue<Integer> q = new PriorityQueue<>();
        for(int i = 1; i <= n; ++i){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }

        for(int i = 0; i < n; ++i){
            int a = q.remove();
            System.out.print(a + " ");
            for(int b : DAG[a]){
                indegrees[b] -= 1;
                if(indegrees[b] == 0){
                    q.add(b);
                }
            }
        }
        System.out.println();
    }
}
