package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 27..
 */
import java.util.*;
public class BJ11051 {
    public static Scanner scanner = new Scanner(System.in);
    public static final long MOD = 10007;
    public static void main(String[] args){
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long[][] c = new long[n+1][n+1];


        for(int i = 0; i <=n; ++i){
            c[i][0] = 1;
            c[i][i] = 1;
            for(int j = 1; j <= i-1; ++j){
                c[i][j] = c[i-1][j-1] + c[i-1][j];
                c[i][j] %= MOD;
            }
        }
        long output = c[n][k];
        System.out.println(output);
    }

}
