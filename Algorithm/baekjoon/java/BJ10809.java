package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 4. 10..
 */
public class BJ10809 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] table = new int['z'-'a'+1];
        Arrays.fill(table, -1);
        for(int i = 0; i < input.length(); ++i){
            char token = input.charAt(i);
            int index = token - 'a';

            if (table[index] == -1){
                table[index] = i;
            }
        }

        StringBuilder output = new StringBuilder();
        for(int i  = 0; i < table.length; ++i){
            output.append(table[i] + " ");
        }

        System.out.println(output);
    }
}
