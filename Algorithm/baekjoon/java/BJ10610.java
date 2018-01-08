package baekjoon.java;

import java.lang.reflect.*;
import java.util.*;

public class BJ10610 {
    public static String max30(String input){
        char[] tokens = input.toCharArray();
        Arrays.sort(tokens);

        int sum = 0;
        for(int i = 0; i < input.length(); ++i){
            int value = tokens[i] - '0';
            sum += value;
        }

        if(tokens[0] == '0' && sum % 3 == 0) {
            for (int i = 0; i < tokens.length / 2; ++i) {
                char temp = tokens[i];
                tokens[i] = tokens[tokens.length - 1 - i];
                tokens[tokens.length - 1 - i] = temp;
            }
            String output = new String(tokens);
            return output;
        }
        else
            return "-1";
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = max30(input);
        System.out.println(output);
    }
}
