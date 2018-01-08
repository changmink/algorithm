package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 3..
 */
import java.util.*;
public class BJ2252 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> DAG[] = new List[n+1];
        for(int i = 1; i <=n; ++i){
            DAG[i] = new ArrayList<Integer>();
        }

        int[] indegrees = new int[n+1];
        for(int i = 0; i < m; ++i){
            int x = sc.nextInt();
            int y = sc.nextInt();
            DAG[x].add(y);
            indegrees[y] += 1;
        }
        //q에는 indegree가 0인 경우만 들어간다.
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <=n; ++i){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }

        for(int i = 1; i <= n; ++i){
            int x = q.remove();
            System.out.print(x + " ");
            for(int y : DAG[x]){
                indegrees[y] -= 1;
                if(indegrees[y] == 0){
                    q.add(y);
                }
            }
        }

        System.out.println();
    }
}
