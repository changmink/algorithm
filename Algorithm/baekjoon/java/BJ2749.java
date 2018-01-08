package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 26..
 */
import java.util.*;

public class BJ2749 {
    public static Scanner scanner = new Scanner(System.in);
    public static final int MAX_PERIOD = 1500000;
    public static final int div = 1000000;
    public static void main(String[] args){
        long n = scanner.nextLong();
        long fibo[] = new long[MAX_PERIOD + 1];
        fibo[1] = 1;

        for(int i = 2; i <= MAX_PERIOD; ++i){
            fibo[i] = fibo[i-1] + fibo[i-2];
            fibo[i] %= div;
        }
        long output = fibo[(int) (n % MAX_PERIOD)];
        System.out.println(output);
    }
}
