package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 26..
 */
import java.util.*;
public class BJ1629 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();

        long output = getNumber(a, b, c);
        System.out.println(output);
    }

    public static long getNumber(long a, long b, long c) {
        if(b == 0)
            return 1;
        else if(b == 1)
            return a % c;
        else if (b % 2 == 1){
            return (a * getNumber(a, b - 1, c)) % c;
        }else{
            long temp = getNumber(a, b / 2, c);
            temp %= c;
            return (temp * temp) % c;
        }
    }
}
