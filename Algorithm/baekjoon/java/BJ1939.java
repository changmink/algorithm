package baekjoon.java;

import java.util.*;

//다시 풀어야함
public class BJ1939 {
    static class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int n;
    static int m;
    static int start;
    static int end;
    static List<Pair> a[] = new List[10001];
    static boolean[] c = new boolean[10001];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < 10001; ++i){
            a[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; ++i){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            a[x].add(new Pair(y, z));
            a[y].add(new Pair(x, z));
        }
        start = sc.nextInt();
        end = sc.nextInt();
        int left = 1;
        int right = 1000000000;
        int output = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            c = new boolean[10001];
            if(go(start, mid)){
                output = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(output);

    }

    private static boolean go(int node, int limit) {
        // 이미 간곳은 갈 수가 없음
        if (c[node]) {
            return false;
        }
        // 방문 한것으로 한다.
        c[node] = true;

        // 순회를 해서 도착지에 도착
        if (node == end) {
            return true;
        }

        //BFS 순회를 한다.
        for (Pair p : a[node]) {
            int next = p.first;
            int cost = p.second;
            if (cost >= limit) {
                if (go(next, limit)) {//순회를 한다.
                    return true;
                }
            }
        }
        return false;
    }
}

