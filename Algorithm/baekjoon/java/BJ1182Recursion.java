package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 20..
 */
public class BJ1182Recursion {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int input[] = new int[n];

        for(int i = 0; i < n; ++i){
            input[i] = scanner.nextInt();
        }

        int output = getCase(input, target, 0,0);
        if(target == 0) output -= 1;
        System.out.println(output);
    }

    public static int getCase(int[] input, int m, int i ,int sum) {
        if(i == input.length){
            if(sum == m) return 1;//만족하면 1이되서 카운트
            else return 0;//만족하지 않으면 0이되서 카운트 안됨
        }
        //i 0~n-1까지 포함하는 경우와 포함하지 않는 경우에 대해서 각각 구해서 더한다.
        return getCase(input, m, i+1, sum + input[i])
                + getCase(input, m, i+1, sum);
    }
}
