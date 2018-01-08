package baekjoon.java;

import java.util.*;


public class BJ11047 {
    static int minimumCoin(int n, int k, int[] values){
        int money = k;
        int coins = 0;

        for(int i = n - 1; i >= 0; --i){
            while(money >= values[i]){
                money -= values[i];
                coins += 1;
            }
            if(money <= 0) break;
        }

        return coins;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] values = new int[n];

        for(int i = 0; i < n; ++i){
            values[i] = scanner.nextInt();
        }

        int output = minimumCoin(n, k, values);

        System.out.println(output);
    }
}
