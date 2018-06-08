package baekjoon.java;

import java.util.*;

public class BJ1373 {
    static int getBase8(int binary){
        int output = 0;

        output += 4 & binary;
        output += 2 & binary;
        output += 1 & binary;

        return output;
    }

    static String getBase2to8(String n){
        StringBuilder stb = new StringBuilder();

        //3으로 나누어 떨어지지 않는다면 모자란 만큼 채워준다.
        int pad = (n.length() % 3 > 0)? 3 - n.length() % 3 : 0;
        for(int i = 0; i < pad; ++i){
            n = '0' + n;
        }

        //3개 자리 씩 끊어서 8진수 구한다.
        for(int i = 0; i < n.length(); i += 3){
            int value = Integer.parseInt(n.substring(i, i+3));
            stb.append(getBase8(value));
        }

        return stb.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String output = getBase2to8(n);
        System.out.println(output);
    }
}
