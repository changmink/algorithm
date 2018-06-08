package baekjoon.java;

import java.util.*;
public class BJ10872 {
    static long facto(int n){
        long output = 1;

        for(int i = 2; i <= n; ++i){
            output *= i;
        }
        return output;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println(facto(sc.nextInt()));
    }
}
