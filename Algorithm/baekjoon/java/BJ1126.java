package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 2..
 */
import java.util.*;
public class BJ1126 {
    public static final int inf = 100000000;
    public static int[] input = new int[50];
    public static int[][] dp = new int[50][250001];
    public static int n;
    public static int go(int k, int diff){
        if(diff > 250000){//높이의 차이가 250000보다 크면 불가
            return -inf;
        }

        if(k == n){//모든 조각 사용
            if(diff == 0){//높이의 차이가 0 일때
                return 0;
            }else{
                return -inf;//불가
            }
        }

        if(dp[k][diff] != -1)
            return dp[k][diff];

        //dp[k][diff] k까지 사용하고 높은 탑과 낮은 탑의 차이가 diff 일때 두 탑에서 같은 높이의 최대값
        // 3가지중 하나를 선택한다. - 가장 큰 값으로 결정된다.

        //조각을 두지 않는 경우 - 차이는 그대로 이고 다음 블록으로 넘어감
        dp[k][diff] = go(k+1, diff);

        //높은 탑에 조각을 두는 경우 - 차이에 더해준다.(높은 탑의 높이만 올라감)
        dp[k][diff] = Math.max(dp[k][diff], go(k+1, diff + input[k]));

        //낮은 탑에 조각을 두는 경우 -
        if(input[k] > diff){
            dp[k][diff] = Math.max(dp[k][diff], diff + go(k+1, input[k] - diff));
        }else{
            dp[k][diff] = Math.max(dp[k][diff], input[k] + go(k+1, diff-input[k]));
        }

        return dp[k][diff];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; ++i){
            input[i] = sc.nextInt();
            Arrays.fill(dp[i], -1);
        }

        int output = go(0, 0);
        if(output <= 0) output = -1;
        System.out.println(output);
    }
}
