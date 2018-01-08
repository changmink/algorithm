package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 27..
 */
import java.util.*;
public class BJ11689 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        long n = scanner.nextLong();
        long output = getGCD1(n);
        System.out.println(output);
    }

    public static long getGCD1(long n){
        long output = n;
        for(int i = 2; i * i <=n; ++i){
            if(n % i == 0){
                while(n % i == 0){
                    n /= i;
                }
                output -= output / i;
            }
        }

        if(n > 1)
            output -= output / n;

        return output;
    }
}
