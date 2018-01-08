package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 18..
 */
public class BJ9005 {
    public static int output = 0;
    public static void solve(int n, int value, int count){
        if(count >= 10)
            return;
        for(int i = 1; i <=3; ++i){
            if(value + i == n)
                output += 1;
            solve(n, value + i, count + 1);
        }
    }
    //다른 방법
    public int go(int count, int sum, int goal){
        if(sum > goal) return 0;
        if(sum == goal) return 1;
        int now = 0;
        for(int i = 1; i <=3; ++i){
            now += go(count + 1, sum + i, goal);
        }
        return now;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();

        for(int i = 0; i < tc; ++i){
            output = 0;
            int n = scanner.nextInt();
            solve(n, 0,0);
            System.out.println(output);
        }
    }
}
