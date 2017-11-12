package BaekJoon;

import java.util.*;

/**
 * Created by changmin on 2017. 9. 22..
 */
public class BJ2902 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        String input = scanner.nextLine();
        char[] token = input.toCharArray();
        String output = "";
        output += token[0];

        for(int i = 1; i < input.length() - 1; ++i){
            if(token[i] == '-'){
                output += token[i+1];
            }
        }
        System.out.println(output);
    }
}
