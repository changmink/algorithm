package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 5..
 */
import java.util.*;
public class BJ7453 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        int[] d = new int[n];

        for(int i = 0; i < n; ++i){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                first.add(a[i] + b[j]);
                second.add(c[i] + d[j]);
            }
        }
        int output = 0;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
               if(first.get(i) == -second.get(j))
                   output += 1;
            }
        }
        System.out.println(output);


    }
}
