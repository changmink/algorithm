package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 13..
 */
public class BJ11723 {
    public static StringBuilder output = new StringBuilder();
    public static int cal(String operation, int value){
        String[] operations = operation.split(" ");
        if(operations.length == 1){
            if(operations[0].equals("all")){
                return value | (~ 0);
            }else{//"empty"
                return 0;
            }
        }else{//length == 2
            int x = Integer.parseInt(operations[1]);
            if(operations[0].equals("add"))
                return value | (1 << x);
            else if(operations[0].equals("remove"))
                return value & ~(1 << x);
            else if(operations[0].equals("toggle"))
                return value ^ (1 << x);
            else{//"check"
                output.append(
                        (value & (1 << x)) > 0 ? 1 : 0
                );
                output.append("\n");
                return value;
            }
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int value = 0;
        for(int i = 0; i < n; ++i){
            String operation = scanner.nextLine();
            value = cal(operation, value);
        }
        System.out.print(output.toString());
    }
}
