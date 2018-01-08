package baekjoon.java;

import java.util.*;

public class BJ10828 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int n = Integer.valueOf(scanner.nextLine());

        Stack<Integer> stack = new Stack<>();
        int output = 0;

        for(int i = 0; i < n; ++i){
            String[] inputs = scanner.nextLine().split(" ");
            String cmd = inputs[0];

            if("push".equals(cmd)){
                int x = Integer.valueOf(inputs[1]);
                stack.push(x);
            }
            else if("pop".equals(cmd)){
                if(stack.isEmpty())
                    output = -1;
                else
                    output = stack.pop();

                System.out.println(output);

            }
            else if("size".equals(cmd)){
                output = stack.size();

                System.out.println(output);
            }
            else if("empty".equals(cmd)){
                if(stack.isEmpty())
                    output = 1;
                else
                    output = 0;

                System.out.println(output);

            }else if("top".equals(cmd)){
                if(stack.isEmpty())
                    output = -1;
                else
                    output = stack.peek();

                System.out.println(output);
            }
        }
    }
}
