package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 15..
 */
public class BJ2447 {
    public static void drawStar(char[][] stars, int row, int col, int size){
        if(size == 1){
            stars[row][col] = '*';
            return;
        }else{
            int next = size / 3;

            for(int r = 0; r < 3; ++r){
                for(int c = 0; c < 3; ++c){
                    if(r == 1 && c == 1)
                        continue;
                    drawStar(stars, row + next * r, col + next * c, next);
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        char[][] stars = new char[size][size];

        for(int i = 0; i < size; ++i){
            for(int j = 0; j < size; ++j){
                stars[i][j] = ' ';
            }
        }

        drawStar(stars, 0, 0, size);

        for(int i = 0; i < size; ++i){
            for(int j = 0; j < size; ++j){
                System.out.print(stars[i][j]);
            }
            System.out.println();
        }
    }
}
