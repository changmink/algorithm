package baekjoon.java;

import java.io.*;
import java.util.*;

/**
 * Created by changmin on 2018. 4. 10..
 */
public class BJ10820 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //여기서는 무제한이지만 저지에서는 끝이 있어서 끝난다.
        while(sc.hasNextLine()){
            String input = sc.nextLine();
            int[] table = new int[4];

            for(int i = 0; i < input.length(); ++i){
                char token = input.charAt(i);
                if('a' <= token && token <= 'z'){
                    table[0] += 1;
                }else if('A' <= token && token <= 'Z'){
                    table[1] += 1;
                }else if('0' <= token && token <= '9'){
                    table[2] += 1;
                }else{
                    table[3] += 1;
                }
            }
            for(int i = 0; i < table.length; ++i) {
                output.append(table[i]);
                output.append(' ');
            }
            output.append('\n');
        }
        sc.close();
        System.out.println(output);
    }
}
