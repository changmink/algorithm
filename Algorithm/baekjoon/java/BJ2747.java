package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 26..
 */
import java.util.*;
public class BJ2747 {
    public static int[] DP = new int[50];

    public static void main(String[] args){
        DP[1] = DP[2] = 1;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int output = fibo(n);
        System.out.println(output);
    }

    public static int fibo(int n){
        if(n <= 2)
            return DP[n];
        else{
            if(DP[n] != 0)
                return DP[n];
            return fibo(n-1) + fibo(n-2);
        }
    }
}
