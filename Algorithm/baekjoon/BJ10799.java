package baekjoon;

import java.util.*;

public class BJ10799 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        String input = scanner.nextLine();
        int output = calPiece(input);
        System.out.println(output);
    }

    private static int calPiece(String input) {
        int output = 0;
        Stack<Character> stack = new Stack<>();
        char[] tokens = input.toCharArray();

        for(int i = 0; i < tokens.length; ++i){
            if(stack.empty()) {
                stack.push(tokens[i]);
            }
            else if(tokens[i-1] == '('){
                if('(' == tokens[i]){
                    stack.push(tokens[i]);
                }else {
                    stack.pop();
                    output += stack.size();
                }
            }
            else if (tokens[i-1] == ')'){
                if('(' == tokens[i]){
                    stack.push(tokens[i]);
                }else{
                    stack.pop();
                    output+= 1;
                }
            }
        }
        return output;
    }
}
