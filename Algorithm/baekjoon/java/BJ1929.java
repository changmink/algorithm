package baekjoon.java;

import java.util.*;

public class BJ1929 {
    static boolean[] getPrimeTable(int n){
        boolean[] table = new boolean[n+1];
        table[0] = table[1] = true;
        for(int i = 2; i * i <= n; ++i){
            if(table[i] == false){
                for(int j = i + 1; j <= n; ++j){
                    if(j % i == 0)
                        table[j] = true;
                }
            }
        }

        return table;
    }

    static String getPrimes(int m, int n){
        StringBuilder output = new StringBuilder();
        boolean[] table = getPrimeTable(n);

        for(int i = m; i <= n; ++i){
            if(table[i] == false) {
                output.append(i);
                output.append('\n');
            }
        }

        return output.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        String output = getPrimes(m, n);
        System.out.println(output);
    }
}
