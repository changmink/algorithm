package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 5..
 */
import java.util.*;
public class BJ1956 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] d = new int[n][n];

        //0을 기준으로 하는 방법
        while(m-- > 0){
            int x = sc.nextInt();
            x -= 1;
            int y = sc.nextInt();
            y -= 1;
            int z = sc.nextInt();

            if(d[x][y] == 0){
                d[x][y] = z;
            }
            else if(d[x][y] > z){
                d[x][y] = z;
            }
        }

        for(int k = 0; k < n; ++k){
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < n; ++j){
                    if(d[i][k] != 0 && d[k][j] != 0){
                        if(d[i][j] == 0 || d[i][j] > d[i][k] + d[k][j]){
                            d[i][j] = d[i][k] + d[k][j];
                        }
                    }
                }
            }
        }

        int output = -1;
        for(int i = 0; i < n; ++i){
            if(d[i][i] != 0){
                if(output == -1 || output > d[i][i]){
                    output = d[i][i];
                }
            }
        }
        System.out.println(output);
    }
}
