package baekjoon.java;

import java.util.*;

public class BJ2004 {
    static long count2byFactorial(long n){
        long output = 0;
        long value = 2;
        while(n >= value){
            output += n / value;
            value *= 2;
        }
        return output;
    }
    static long count5byFactorial(long n){
        long output = 0;
        long value = 5;
        while(n >= value){
            output += n / value;
            value *= 5;
        }
        return output;
    }

    static long count10byConbination(long n, long m){
        long count2 = count2byFactorial(n);
        count2 -= count2byFactorial(m);
        count2 -= count2byFactorial(n-m);

        long count5 = count5byFactorial(n);
        count5 -= count5byFactorial(m);
        count5 -= count5byFactorial(n-m);

        return Math.min(count2, count5);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        System.out.println(count10byConbination(n, m));
    }
}

