package baekjoon.java;

import java.sql.*;
import java.util.*;

/**
 * Created by changmin on 2017. 12. 16..
 */
public class BJ2805 {
    public static int getMaxSawLength(int[] woods, int n, int m){
        int l = 0;
        int r = Arrays.stream(woods).max().getAsInt();

        int output = 0;

        while(l <= r){
            int mid = (l + r) / 2;
            if(checkHeight(woods, n, m, mid)){
                l = mid + 1;
                output = Math.max(output, mid);
            }
            else{
                r = mid - 1;
            }
        }

        return output;
    }

    public static boolean checkHeight(int[] woods, int n, int m, int h){
        int sum = 0;

        for(int i = 0; i < n; ++i){
            if(woods[i] - h > 0)
                sum += woods[i] - h;
        }

        return sum >= m;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] woods = new int[n];

        for(int i = 0; i < n; ++i){
            woods[i] = scanner.nextInt();
        }
        int output = getMaxSawLength(woods, n, m);
        System.out.println(output);
    }
}
