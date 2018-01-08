package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 27..
 */
public class BJ11439 {
    //n의 p승이 몇인지를 샌다.
    public static long count(long n, long p){
        long output = 0;

        while(n > 0){
            output += n/p;
            n /= p;
        }
        return output;
    }

    //a^b의 값을 mod로 나눈 나머지
    public static long powMod(long a, long b, long mod){
        long output = 1;
        long y = a;
        while(b > 0){
            if(b % 2 == 1){
                output *= y;
                output %= mod;
            }

            y *= y;
            y %= mod;
            b /= 2;
        }

        return output;
    }

    public static long cal(long n, long m, long mod){
        long output = 1;
        boolean[] check = new boolean[(int)(n + 1)];
        for(int i = 0; i <= n; ++i){
            check[i] = true;
        }

        for(int i = 2; i <= n; ++i){
            if(check[i]){
                for(int j = 2 * i; j <= n; j += i){
                    check[j] = false;
                }

                long k = count(n, i) - count(m, i) - count(n - m, i);
                output = output * powMod(i, k, mod);
                output = output % mod;
            }
        }
        return output;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long k = scanner.nextLong();

        System.out.println(cal(n, m, k));
    }
}
