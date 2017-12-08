package backjoon;

import java.util.*;

public class BJ9012 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        int n = Integer.valueOf(scanner.nextLine());

        for(int i = 0; i < n; ++i){
            String input = scanner.nextLine();
            if(checkVPS(input))
                System.out.println("YES");
            else
                System.out.println("NO");
        }

    }

     private static boolean checkVPS(String input) {
        Stack<Character> stack = new Stack<>();

        for(char token : input.toCharArray()){
            if(token == '(')
                stack.push(token);
            else if(token == ')') {
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}

