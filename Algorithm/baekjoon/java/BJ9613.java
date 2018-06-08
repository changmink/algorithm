package baekjoon.java;

import java.util.*;
public class BJ9613 {
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
            int n = sc.nextInt();
            int[] inputs = new int[n];
            for(int j = 0; j < n; ++j){
                inputs[j] = sc.nextInt();
            }
            long sum = gcdSum(inputs);
            output.append(sum);
            output.append('\n');
        }

        System.out.println(output);
    }

    private static long gcdSum(int[] inputs) {
        long output = 0;
        for(int i = 0; i < inputs.length - 1; ++i) {
            for(int j = i; j < inputs.length; ++j){
                if(i == j) continue;
                output += gcd(inputs[i], inputs[j]);
            }
        }
        return output;
    }
}
