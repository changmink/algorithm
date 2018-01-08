package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 3..
 */
import java.util.*;
public class BJ2056 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        int times[] = new int[n + 1];
        int indegrees[] = new int[n + 1];

        //i가 끝났을때 경과 시간
        int elapsed[] = new int[n + 1];

        List<Integer>[] DAG = new List[n + 1];
        for(int i = 1; i <= n; ++i){
            DAG[i] = new ArrayList<Integer>();
        }

        for(int i = 1; i <= n; ++i){
            times[i] = sc.nextInt();
            int indegree = indegrees[i] = sc.nextInt();
            for(int j = 0; j < indegree; ++j) {
                int value = sc.nextInt();
                DAG[value].add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; ++i){
            if(indegrees[i] == 0){
                q.add(i);
                elapsed[i] = times[i];
            }
        }

        for(int i = 0; i < n; ++i){
            int a = q.remove();
            for(int b : DAG[a]){
                indegrees[b] -= 1;

                if(elapsed[b] < elapsed[a] + times[b]){
                    elapsed[b] = elapsed[a] + times[b];
                }

                if(indegrees[b] == 0) {
                    q.add(b);
                }

            }
        }
        int output = 0;
        for(int i = 1; i <= n; ++i){
            output = Math.max(output, elapsed[i]);
        }
        System.out.println(output);

    }
}
