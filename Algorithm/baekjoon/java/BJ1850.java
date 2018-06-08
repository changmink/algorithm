package baekjoon.java;

import java.util.*;
public class BJ1850{
    static long gcd(long a, long b){
        while(b != 0){
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();


        long gcd = gcd(a, b);
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < gcd; ++i){
            output.append(1);
        }
        System.out.println(output);
    }
}
