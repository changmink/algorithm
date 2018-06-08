package baekjoon.java;

import java.util.*;

public class BJ1676 {
    static int howManyZeroEndFromFactorial(int n){
        //뒤에 0이 있으려면 10을 곱해야함
        //곱하는 수 중에 10이 몇개 인지를 센다
        //10은 5 * 2
        //2는 짝수마다 존재 하므로 5의 개수만 샌다.

        // 5가 1개인 경우
        int output = n / 5;

        // 5가 2개인 경우

        output += n / 25;

        // 5가 3개인 경우
        output += n / 125;

        return output;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println(howManyZeroEndFromFactorial(sc.nextInt()));
    }
}
