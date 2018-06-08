package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 3. 22..
 */
public class BJ11725 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> tree[] = new List[n+1];
        for(int i = 1; i <= n; ++i){
           tree[i] = new ArrayList<Integer>();
        }

        for(int i = 1; i < n; ++i){
           int x = sc.nextInt();
           int y = sc.nextInt();
           tree[x].add(y);
           tree[y].add(x);
        }

        int[] table = bfs(tree, 1);
        for(int i = 2 ; i < table.length; ++i){
            System.out.println(table[i]);
        }
    }

    private static int[] bfs(List<Integer>[] tree, int start) {
        boolean check[] = new boolean[tree.length];
        int table[] = new int[tree.length];
        check[0] = true;
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        check[1] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int vertex : tree[node]){
                if(check[vertex] == false){
                    check[vertex] = true;
                    q.offer(vertex);
                    table[vertex] = node;
                }
            }
        }

        return table;

    }
}
