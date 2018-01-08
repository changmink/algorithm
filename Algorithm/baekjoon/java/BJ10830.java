package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 26..
 */
import java.util.*;
public class BJ10830 {
    public static final int DIV = 1000;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long b = scanner.nextLong();

        int input[][] = new int[n][n];
        int output[][] = new int[n][n];

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                input[i][j] = scanner.nextInt();
            }

            //단위 행렬
            output[i][i] = 1;
        }

        while(b > 0){
            if(b % 2 == 1){
                output = mulArray(output, input);
            }

            input = mulArray(input, input);
            b /= 2;
        }

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] mulArray(int[][] input1, int[][] input2){
        int n = input1.length;
        int output[][] = new int[n][n];

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                for(int k = 0; k < n; ++k){
                    output[i][j] += input1[i][k] * input2[k][j];
                }
                output[i][j] %= DIV;
            }
        }

        return output;
    }
}
