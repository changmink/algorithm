package baekjoon.java;

import java.util.*;

public class BJ1978 {
    static boolean isPrime(int value){
        if(value < 2)
            return false;

        for(int i = 2; i * i <= value; ++i){
            if(value % i == 0)
                return false;
        }
        return true;
    }

    static int countPrime(int[] inputs){
        int count = 0;
        for(int i = 0; i < inputs.length; ++i){
            if(isPrime(inputs[i]))
                count += 1;
        }
        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int inputs[] = new int[n];

        for(int i = 0; i < n; ++i){
            inputs[i] = sc.nextInt();
        }

        int output = countPrime(inputs);
        System.out.println(output);
    }
}
