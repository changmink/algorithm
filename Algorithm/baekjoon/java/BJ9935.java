package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 22..
 */
import baekjoon.java.*;

import java.util.*;

public class BJ9935 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String bomb = scanner.nextLine();
        int  n = input.length();
        int m = input.length();
        boolean[] boom= new boolean[n];

        if(m == 1){//1인 경우는 전체에서 찾는다.
            for(int i = 0; i < n; ++i){
                if(input.charAt(i) == bomb.charAt(0)){
                    boom[i] = true;
                }
            }
        }else{
            Stack<Pair> stack = new Stack<>();
            for(int i = 0; i < n; ++i){
                if(input.charAt(i) == bomb.charAt(0)){
                    stack.push(new Pair(i, 0));
                }else{
                    if(!stack.empty()){//스택에 내용이 있을때만 스택이 비었으면 넘어간다.
                        Pair p = stack.peek();
                        if(input.charAt(i) == bomb.charAt(p.second + 1)){
                            stack.push(new Pair(i, p.second + 1));
                            if(p.second + 1 == m - 1){//마지
                                for(int k = 0; i < m; k++){
                                    Pair top = stack.pop();
                                    boom[top.first] = true;
                                }
                            }
                        }else{//같지 않으면 전체를 비운다.
                            while(!stack.empty()){
                                stack.pop();
                            }
                        }
                    }
                }
            }
        }

        boolean print = false;
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < n; ++i){
            if(boom[i]){
                continue;
            }
            output.append(input.charAt(i));
            print = true;
        }

        if(print){
            System.out.println(output.toString());
        }else{
            System.out.println("FRULA");
        }

    }
}
