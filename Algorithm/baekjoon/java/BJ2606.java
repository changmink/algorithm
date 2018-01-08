package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 23..
 */
public class BJ2606 {
    public static int size = 101;
    public static int[] parent = new int [size];
    public static int Find(int x){
        if(x == parent[x]){
            return x;
        } else{
            return parent[x] = Find(parent[x]);
        }
    }

    public static void Union(int x, int y){
        x = Find(x);
        y = Find(y);
        if(x != y){
            parent[y] = x;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for(int i = 1; i<n; ++i){
            parent[i] = i;
        }

        while(m-- > 0){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Union(x, y);
        }

        int output = 0;
        for(int i = 2; i <= n; ++i){
            if(Find(1) == Find(i)){//1이 감염되어 있는데 이와 루트가 같다면
                output += 1;
            }
        }

        System.out.println(output);
    }

}
