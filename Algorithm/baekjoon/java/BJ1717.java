package baekjoon.java;

import java.io.*;
import java.util.*;

/**
 * Created by changmin on 2017. 12. 23..
 */
public class BJ1717 {
    public static final int size = 1000001;
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

        for(int i  = 0; i <=n; ++i){
            parent[i] = i;
        }

        while(m-- > 0){
            int w = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if(w == 0){//합집합
                Union(x, y);
            }else{//w == 1 인경우
                x = Find(x);
                y = Find(y);
                if(x == y){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }

        }
    }

}
