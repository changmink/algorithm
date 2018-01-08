package baekjoon.java;

import java.util.*;
public class BJ11438 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>[] a = new List[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Integer>();
        }

        for (int i=1; i<=n-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x].add(y);
            a[y].add(x);
        }

        int[] depth = new int[n+1];
        boolean[] check = new boolean[n+1];
        int[] parent = new int[n+1];
        int start = 1;
        Queue<Integer> q = new LinkedList<Integer>();
        check[start] = true;
        depth[start] = 0;
        parent[start] = 0;
        q.add(start);
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : a[x]) {
                if (check[y] == false) {
                    depth[y] = depth[x] + 1;
                    check[y] = true;
                    parent[y] = x;
                    q.add(y);
                }
            }
        }

        //log를 이용해서 찾는다 2^n이므로 비트연산가능
        int log = 1;
        while((1<<log) <= n){
            log +=1 ;
        }
        log -=1;
        int[][] p = new int[n+1][log+1];

        // 다이나믹의 초기값
        for(int i = 1; i <= n; ++i){
            p[i][0] = parent[i];
        }
        // 부모의 부모를 dp를 이용해서 찾는다.
        for(int j = 1; (1<<j) < n; ++j){
            for(int i = 1; i <= n; ++i){
                if(p[i][j-1] != 0){
                    p[i][j] = p[p[i][j-1]][j-1];
                }
            }
        }

        int m = sc.nextInt();
        while(m-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(depth[x] < depth[y]){
                int temp = x;
                x = y;
                y = temp;
            }
            //log를 구해서 최대 몇카나지 올라 갈수 있는지를 구한다.
            log = 1;
            while((1<<log) <= n){
                log += 1;
            }
            log -= 1;
            //레벨이 같을때까지 찾음
            for(int i = log; i >= 0; --i){
                if(depth[x] - (1<<i) >= depth[y]){
                    x = p[x][i];
                }
            }

            if(x == y){//예외
                System.out.println(x);
            }else{
                //레벨은 같지만 노드가 다른 경우
                for(int i = log; i >= 0; --i){
                    //노드가 같을때까지 위로 올라간다.
                    if(p[x][i] != 0 && p[x][i] != p[y][i]){
                        x = p[x][i];
                        y = p[y][i];
                    }
                }
                System.out.println(parent[x]);
            }
        }

    }
}
