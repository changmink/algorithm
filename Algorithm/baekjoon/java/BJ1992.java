package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 15..
 */
public class BJ1992 {
    public static String quardTree(char[][] inputs, int row, int col, int size){
        if(size == 1) {
            return String.valueOf(inputs[row][col]);
        }
        if(sameValue(inputs, row, col, size)){
            return String.valueOf(inputs[row][col]);
        }else {
            int nextSize = size / 2;
            StringBuilder stb = new StringBuilder();
            stb.append("(");
            stb.append(quardTree(inputs, row, col , nextSize));
            stb.append(quardTree(inputs, row, col + nextSize, nextSize));
            stb.append(quardTree(inputs, row + nextSize, col, nextSize));
            stb.append(quardTree(inputs, row + nextSize, col + nextSize, nextSize));
            stb.append(")");
            return stb.toString();
        }
    }

    private static boolean sameValue(char[][] inputs, int row, int col, int size) {
        char value = inputs[row][col];
        for(int r = row; r < row + size; ++r){
            for(int c = col; c < col + size; ++c){
                if(value != inputs[r][c])
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

        String output = quardTree(inputs, 0,0, size);
        System.out.println(output);
    }
}
