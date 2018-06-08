package baekjoon.java;

import java.util.*;

public class BJ6588 {
    static final int MAX = 1000000;
    static int[] primes = new int[MAX + 1];
    static boolean[] table;

    static void getPrimeEvens(int n){
        table = new boolean[n + 1];
        table[0] = table[1] = true;
        int index = 0;
        for(int i = 2; i * i <= n; ++i){
            if(table[i] == false){
                primes[index++] = i;
                for(int j = i + 1; j <= n; ++j){
                    if(j % i == 0){
                        table[j] = true;
                    }
                }
            }
        }

    }

    static String checkCase(int n){
        //맨 처음 소수는 2이므로 제거하고 시작
        for(int i = 1; i < n; ++i){
            int a = primes[i];
            int b = n - a;

            //맨 처음에 만난 a 값이 b-a의 최대 값을 만든다. 때문에 따로 비교할 필요가 없다.
            if(table[b] == false){
                return n + " = " + a + " + " + b;
            }
        }
        return "Goldbach's conjecture is wrong.";


    }

    public static void main(String[] args){
        getPrimeEvens(MAX);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder output = new StringBuilder();

        while(n > 0){
            output.append(checkCase(n));
            output.append('\n');
            n = sc.nextInt();
        }
        System.out.println(output);
    }
}
