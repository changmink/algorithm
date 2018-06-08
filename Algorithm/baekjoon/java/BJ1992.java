package baekjoon.java;

import java.util.*;

class BJ1992 {
    public static String quadTree(char[][] input, int s1, int s2, int size){
        StringBuilder output = new StringBuilder();

        if(same(input, s1, s2, size)){
            output.append(input[s1][s2]);
        }else{
            size = size / 2;

            output.append("(");
            output.append(quadTree(input, s1, s2, size));
            output.append(quadTree(input, s1, s2 + size, size));
            output.append(quadTree(input, s1 + size, s2, size));
            output.append(quadTree(input, s1 + size, s2 + size, size));
            output.append(")");
        }

        return output.toString();
    }

    static boolean same(char[][]input, int s1, int s2, int size){
        for(int i = s1; i < s1 + size; ++i){
            for(int j = s2; j < s2 + size; ++j){
                if(input[i][j] != input[s1][s2])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] inputs = new char[size][size];

        for(int i = 0; i < size; ++i) {
            inputs[i] = scanner.nextLine().toCharArray();
        }

        String output = quadTree(inputs, 0,0, size);
        System.out.println(output);
    }
}
