package baekjoon.java;
import java.util.*;
/**
 * Created by changmin on 2017. 12. 27..
 */
public class BJ11401 {
    public static final long MOD = 1000000007;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long temp1 = 1;
        long temp2 = 1;

        //(n-k)!
        for(long i = 0; i < k; ++i){
            temp1 *= (n - i);
            temp1 %= MOD;
        }

        //(k)!
        for(long i = 1; i <= k; ++i){
            temp2 *= i;
            temp2 %= MOD;
        }

        long temp3 = powMod(temp2, MOD - 2);
        temp3 %= MOD;


        //k!(n-k)!
        long output = temp1 * temp3;
        output %= MOD;
        System.out.println(output);
    }

    public static long powMod(long a, long b){
        long output = 1;

        while(b > 0){
            if(b % 2 == 1){
                output *= a;
                output %= MOD;
            }

            a *= a;
            a %= MOD;
            b /= 2;
        }
        return output;
    }
}
