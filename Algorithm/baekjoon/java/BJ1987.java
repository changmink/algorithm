package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 20..
 */
public class BJ1987 {
    public static final int[] dx = new int[]{1, -1, 0, 0,};
    public static final int[] dy = new int[]{0, 0, 1, -1};
    public static int output = 0;

    public static void go(String[] board, boolean[] check, int x, int y, int count){
        if(count > output) output = count;

        for(int i = 0; i < 4; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length()){
                if(false == check[(board[nx].charAt(ny) - 'A')]){
                    check[board[nx].charAt(ny) - 'A'] = true;
                    go(board, check, nx, ny, count + 1);
                    check[board[nx].charAt(ny) - 'A'] = false;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();

        String[] board = new String[r];
        for(int i = 0; i < r; ++i){
            board[i] = scanner.nextLine();
        }

        boolean[] check = new boolean['z' - 'a' + 1];
        check[board[0].charAt(0)-'A'] = true;
        go(board, check, 0 ,0, 1);
        System.out.println(output);
    }
}
