package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 26..
 */
import java.util.*;
public class BJ1629Binary {
    public static void main(String[] args){
        Scanner  scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b =  scanner.nextLong();
        long c = scanner.nextLong();

        long output = getNumber(a, b, c);
        System.out.println(output);
    }

    public static long getNumber(long a, long b, long c){
        long output = 1;

        while(b > 0){
            if(b % 2 == 1){
                output *= a;
                output %= c;
            }

            a = (a * a) % c;

            b = b / 2;
        }

        return output;
    }
}
