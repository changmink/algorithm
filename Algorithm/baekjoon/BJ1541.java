package baekjoon;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 12..
 */
public class BJ1541 {
    public static int calMininum(String input){
        int startIndex = 0;
        boolean minusFlag = false;
        int value = 0;
        int output = 0;

        for(int i = 0; i < input.length(); ++i){
            char token = input.charAt(i);

            if(token == '-' || token == '+'){
                value = Integer.parseInt(input.substring(startIndex, i));

                if(minusFlag)
                    output -= value;
                else
                    output += value;

                if(token == '-')
                    minusFlag = true;

                startIndex = i + 1;
            }
        }
        value = Integer.parseInt(input.substring(startIndex));

        if(minusFlag)
            output -= value;
        else
            output += value;

        return output;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int output = calMininum(input);

        System.out.println(output);
    }
}
