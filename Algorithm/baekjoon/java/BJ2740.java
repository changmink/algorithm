package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 26..
 */
import java.util.*;
public class BJ2740 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a[][] = new int[n][m];

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                a[i][j] = scanner.nextInt();
            }
        }

        m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] b = new int[m][k];

        for(int i = 0; i < m; ++i){
            for(int j = 0; j < k; ++j){
                b[i][j] = scanner.nextInt();
            }
        }

        int output[][] = new int[n][k];

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < k; ++j){
               for(int z = 0; z < m; ++z) {
                   output[i][j] += a[i][z] * b[z][j];
               }
            }
        }

        for(int i  = 0; i < n; ++i){
            for(int j = 0; j < k; ++j){
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
}
