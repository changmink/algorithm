package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 2..
 */
import java.util.*;
public class BJ3012 {
    static long dp[][] = new long[200][200];
    static char open[] = {'(', '{', '['};
    static char close[] = {')', '}', ']'};
    static final long MOD = 100000;//5자리 아래로 나오게 하려고 사용
    static boolean over = false;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String input = sc.next();
        for(int i = 0; i < n; ++i){
            Arrays.fill(dp[i],-1);
        }
        long output = go(input, 0, n-1);

        if(over) {
            System.out.println(String.format("%05d", output));
        }
        else{
            System.out.println(output);
        }


    }
    public static long go(String input, int i, int j){
        if(i > j){
            return 1;
        }

        long output = dp[i][j];
        if(dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = 0;
        for(int k = i + 1; k <= j; k += 2){//여는 괄호 닫는 괄호 니까 2칸씩 확인한다 짝수개
            for(int l = 0; l < 3; ++l){
                //i, k가 짝이 맞는지를 확인한다. 이후 나머지 경우의수를 구해서 곱한다.
                if(input.charAt(i) == open[l] || input.charAt(i) == '?'){
                    if(input.charAt(k) == close[l] || input.charAt(k) == '?'){
                        long temp = go(input, i+1, k-1) * go(input, k+1, j);//거리는 짝수가 되어야함
                        if(dp[i][j] + temp > MOD){
                            over = true;
                        }
                        dp[i][j] += temp;
                        dp[i][j] %= MOD;
                    }
                }
            }
        }

        return dp[i][j];
    }
}
