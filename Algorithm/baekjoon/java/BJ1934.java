package baekjoon.java;


import java.util.*;

public class BJ1934 {
    static long lcm(int a, int b){
        return a * b / gcd(a, b);
    }
    static int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        int t = sc.nextInt();
        for(int i = 0; i < t; ++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            output.append(lcm(a, b));
            output.append('\n');
        }
        System.out.println(output);
    }
}
