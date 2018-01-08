package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 26..
 */
import java.util.*;
public class BJ11444 {
    public static Scanner scanner = new Scanner(System.in);
    public static final long MOD = 1000000007;
    public static Map<Long, Long> map = new HashMap<>();
    public static void main(String[] args){
       long n = scanner.nextLong();
       long output = fibo(n);
       System.out.println(output);
    }

    private static long fibo(long n) {
        if(n <= 0)
            return 0;
        else if(n <= 2)
            return 1;
        else if(map.containsKey(n))
            return map.get(n);
        else{
            if( n % 2 == 1){
                long mid = (n + 1) / 2;
                long f1 = fibo(mid);
                long f2 = fibo(mid-1);
                long value = f1 * f1 + f2 * f2;
                value %= MOD;
                map.put(n, value);
                return map.get(n);
            }else{
                long mid = n / 2;
                long f1 = fibo(mid-1);
                long f2 = fibo(mid);
                long value = (2* f1 + f2) * f2;
                value %= MOD;
                map.put(n, value);
                return map.get(n);
            }
        }
    }
}
