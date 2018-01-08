package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 1. 6..
 */
public class BJ10868SegmentTree {
    public static int tree[] = new int[100001];
    public static int a[] = new int[100001];
    public static int query(int node, int start, int end, int i, int j){
        // 구간이 겹치지 않는 경우
        if(i > end || j < start) return -1;
        // 구간을 포함하는 경우
        if(i <= start && end <= j) return tree[node];
        //왼쪽 자식의 최소값
        int m1 = query(2 * node, start, (start + end) / 2, i, j);
        //오른쪽 자식의 최소값
        int m2 = query(2 * node + 1, (start + end) / 2 + 1, end, i , j);
        //m1, m2 중 하나는 무조건 포함 돤다.
        if(m1 == -1) return m2;
        else if(m2 == -1) return m1;
        else return Math.min(m1, m2);
    }
    //노드 번호와 구간이 입력
    public static void init(int node, int start, int end){
        //리프 노드
        if(start == end)
            tree[node] = a[start];
        else
        {
            init(node * 2, start, (start + end) / 2);
            init(node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0; i < n; ++i){
            a[i] = sc.nextInt();
        }

        init(1, 0, n-1);

        for(int i = 0; i < m; ++i){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int output = query(1, 0, n-1, start-1, end-1);
            System.out.println(output);
        }
    }
}
