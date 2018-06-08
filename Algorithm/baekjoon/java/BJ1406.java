package baekjoon.java;

import java.io.*;
import java.util.*;

/**
 * Created by changmin on 2018. 4. 4..
 * 어짜피 nextLine으로 할꺼면 BufferedReader.readLine() 사용하기
 */
public class BJ1406 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        String input = br.readLine();

        for(char token : input.toCharArray()){
            s1.push(token);
        }

        int n = Integer.parseInt(br.readLine());

        for(int cmd = 0; cmd < n; ++cmd){
            input = br.readLine();
            if('P' == input.charAt(0)){
                //P $
                //012
                s1.push(input.charAt(2));
            }else if(input.equals("L")){
                if(s1.isEmpty())
                    continue;

                s2.push(s1.pop());
            }
            else if(input.equals("D")){
                if(s2.isEmpty())
                    continue;

                s1.push(s2.pop());
            }else{//"B"
                if(s1.isEmpty())
                    continue;

                s1.pop();
            }
        }

        StringBuilder output = new StringBuilder();

        while(!s1.empty()){
            s2.push(s1.pop());
        }
        while(!s2.empty()){
            output.append(s2.pop());
        }

        System.out.println(output.toString());
    }
}
