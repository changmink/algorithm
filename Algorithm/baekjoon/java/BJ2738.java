package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 26..
 */
import java.util.*;
public class BJ2738 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int input1[][] = new int[n][m];
        int input2[][] = new int[n][m];
        int output[][] = new int[n][m];

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                input1[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                input2[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                output[i][j] = input1[i][j] + input2[i][j];
            }
        }

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
}
