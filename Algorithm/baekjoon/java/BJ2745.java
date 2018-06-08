package baekjoon.java;

import java.util.*;
public class BJ2745 {
    static int table[];

    static {
        int tableLength = 36 - 10 + 1;
        table = new int[tableLength];
        for(int i = 0; i < tableLength; ++i){
            table[i] = 10 + i;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String n = input[0];
        int b = Integer.parseInt(input[1]);

        int output = getBase10(n, b);
        System.out.println(output);
    }

    private static int getBase10(String n, int b) {
        StringBuilder temp = new StringBuilder();
        temp.append(n);
        String tokens = temp.reverse()
                            .toString();
        int value = 0;
        int output = 0;
        int k = 0;
        for(char token : tokens.toCharArray()){
            if(token >= 'A' && token <= 'Z'){
                value = table[token-'A'];
            }else{
                value = token - '0';
            }
            output += value * (int)Math.pow(b, k++);
        }
        return output;
    }
}
