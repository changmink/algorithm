package baekjoon.java;

import java.io.*;
import java.util.*;
/*
30 8
25
29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29 29
* */
public class BJ11576 {
    static int getBase10(int baseA, int a[]){
        int output = 0;//30의 36승은 int를 넘는다.
        for(int i = 0; i < a.length; ++i){
           output = output * baseA + a[i];
           System.out.println(output);
        }
        return output;
    }

    static void printBase(int n, int base){
        if(n == 0)
            return;
        else{
            printBase(n/base, base);
            System.out.print(n % base + " ");
        }
    }



    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int baseA = sc.nextInt();
        int baseB = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[m];

        for(int i = 0; i < m; ++i){
            a[i] = sc.nextInt();
        }

        //solution1
        printBase(getBase10(baseA, a), baseB);
//        int[] input = new int[25];
//        for(int i = 0; i < 25; ++i){
//            input[i] = 29;
//        }

//        System.out.println(getBase10(30, input));
    }
}

