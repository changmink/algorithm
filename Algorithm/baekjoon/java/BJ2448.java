package baekjoon.java;

import java.util.*;

public class BJ2448 {
    public static char[][] output = new char[4000][8000];
    public static void drawStar(int row, int mid, int size) {
        if (size == 3) {
            for (int i = row; i < row + 5; ++i) {
                for (int j = mid - 2; j <= mid + 2; ++j) {
                    if (i == row && j == mid) output[i][j] = '*';
                    else if (i == row + 2) output[i][j] = '*';
                    else if (i == row + 1 && (j == mid - 1 || j == mid + 1)) output[i][j] = '*';
                }
            }
        }else{
            size = size / 2;
            drawStar(row, mid, size);
            drawStar(row + size, mid - size, size );
            drawStar(row + size, mid + size, size);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int size = 32 * 3;//sc.nextInt();

        drawStar(0, size-1, size);
        StringBuilder stb = new StringBuilder();
        for(int i = 0; i < size; ++i){
            for(int j = 0; j < size * 2 - 1; ++j) {
               if(output[i][j] == '*')stb.append('*');
               else stb.append(' ');
            }
            stb.append('\n');
        }

        System.out.print(stb);
    }
}
