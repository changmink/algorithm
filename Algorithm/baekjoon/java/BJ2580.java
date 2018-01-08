package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 19..
 */

public class BJ2580 {
    public static final int n = 9;

    //x,y를 입력 받아서 해당 정사각형의 위치 (2차원에서 1차원으로)
    public static int square(int x, int y){
        return (x / 3) * 3 + (y / 3);
    }

    public static boolean go(int[][] board, boolean[][][] check, int z){
        if(z == n * n){// 전체 판을 다 돌았다면 출력한다.
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < n; ++j){
                    System.out.println(board[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }

        //일차원에서 2차원으로 표현
        int x = z / n;
        int y = z % n;

        if(board[x][y] != 0){// 빈칸이 없으면
            return go(board, check, z + 1);
        }else{//빈칸(0인 경우)만 확인
            for(int i = 1; i <= 9; ++i){//각각이 들어 갈수있는지 확인
                if(!check[0][x][i]//행에 i가 있는지
                        && !check[1][y][i]//열에 i가 있는지
                        && !check[2][square(x, y)][i])// 3*3정사각형에 i가 있는지
                {
                    check[0][x][i] = check[1][y][i] = check[2][square(x, y)][i] = true;

                    board[x][y] = i;
                    if(go(board, check, z + 1)){
                        return true;
                    }

                    check[0][x][i] = check[1][y][i] = check[2][square(x, y)][i] = false;
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[n][n];
        boolean[][][] check = new boolean[3][n][10];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                board[i][j] = scanner.nextInt();
                if(board[i][j] != 0){
                    check[0][i][board[i][j]] = true;
                    check[1][j][board[i][j]] = true;
                    check[2][square(i, j)][board[i][j]] = true;
                }
            }
        }

        go(board, check, 0);
    }
}
