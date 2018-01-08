package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 26..
 */
import java.util.*;
public class BJ2748 {
    public static long DP[] = new long[91];
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        DP[2] = DP[1] = 1;
        int n = scanner.nextInt();
        long output = fibo(n);
        System.out.println(output);
    }

    public static long fibo(int n){
        for(int i = 3; i < n+1 ; ++i)
            DP[i] = DP[i - 1] + DP[i - 2];
        return DP[n];
    }
}
