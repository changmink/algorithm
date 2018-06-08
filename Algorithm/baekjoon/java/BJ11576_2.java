package baekjoon.java;

import java.util.*;
public class BJ11576_2 {
    static long getBase10(int baseA, int a[]){
        long output = 0;//30의 36승은 int를 넘는다.
        for(int i = 0; i < a.length; ++i){
            output += a[i] * Math.pow(baseA, a.length - i - 1);
        }
        return output;
    }

    static String getBaseB(int baseB,long decimal){
        StringBuilder output = new StringBuilder();
        while(decimal != 0){
            long r = decimal % baseB;
            decimal /= baseB;
            output.insert(0, r + " ");
        }
        return output.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int baseA = sc.nextInt();
        int baseB = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[m];
        for(int i = 0; i < m; ++i){
            a[i] = sc.nextInt();
        }

        System.out.println(getBaseB(baseB, getBase10(baseA, a)));
    }
}
