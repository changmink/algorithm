package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 4..
 */
import java.util.*;
public class BJ11403 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input[][] = new int[n + 1][n + 1];
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= n; ++j){
                input[i][j] = sc.nextInt();
            }
        }

        for(int k = 1; k <= n; ++k){
            for(int i = 1; i <= n; ++i){
                for(int j = 1; j <= n; ++j){
                    if(input[i][k] == 1 && input[k][j] == 1){
                        input[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= n; ++j){
                System.out.print(input[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
