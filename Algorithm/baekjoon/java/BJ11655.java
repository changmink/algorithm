package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 4. 10..
 */
public class BJ11655 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] tokens = input.toCharArray();
        for(int i = 0; i < tokens.length; ++i){
            char token = tokens[i];
            if('a' <= token && token <= 'z'){
                char rot13 = (char)(token + 13);
                if(rot13 > 'z'){
                    rot13 -= 'z';
                    rot13 += 'a';
                    rot13 -= 1;
                }
                tokens[i] = rot13;
            }else if('A' <= token && token <='Z'){
                char rot13 = (char)(token + 13);
                if(rot13 > 'Z'){
                    rot13 -= 'Z';
                    rot13 += 'A';
                    rot13 -= 1;
                }
                tokens[i] = rot13;
            }
        }

        System.out.println(new String(tokens));
    }
}
