package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 23..
 */
public class BJ6549 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while(n != 0){
            int input[] = new int[n];
            for(int i = 0; i < n; ++i){
                input[i] = scanner.nextInt();
            }

            Stack<Integer> stack = new Stack<>();
            int output = 0;
            for(int i = 0; i < n; ++i){
                int left = i;
                while(!stack.empty() && input[stack.peek()] > input[i]){
                    int height = input[stack.peek()];
                    stack.pop();
                    int width = i;
                    if(!stack.empty()) width = (i - stack.peek() - 1);
                    if(output < width * height) output = width * height;
                }
                stack.push(i);
            }

            n = scanner.nextInt();
        }
    }
}
