package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 15..
 */
public class BJ1074 {
    public static long count = 0;
    public static int power2(int value){
        return 1 << value;
    }

    public static int z(int row, int col, int value){
        if(value == 1){
            return 2 * row + col;
        }else{
            int nextValue = value - 1;
            int revisionPos = power2(nextValue);
            int revisionValue = power2(2 * value - 2);

            if(row < power2(nextValue)){
                if(col < power2(nextValue )){
                    return z(row, col, nextValue);
                }else{
                    return z(row, col - revisionPos, nextValue) + revisionValue;//시작 위치 보정
                }
            }else{
                if(col < power2(nextValue )){
                    return z(row - revisionPos, col, nextValue) + revisionValue * 2;
                }
                else{
                    return z(row - revisionPos, col - revisionPos, nextValue) + revisionValue * 3;
                }
            }

        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        int output = z(row, col, value);
        System.out.println(output);
    }
}
