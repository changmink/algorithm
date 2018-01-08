package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 1. 5..
 */
public class BJ1806 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int input[] = new int[n+1];
        for(int i = 0 ; i < n; ++i){
            input[i] = sc.nextInt();
        }
        int left = 0;
        int right = 0;
        int sum = input[0];
        int output = n+1;
        while(left <= right && right < n){
            if(sum < target){
                right +=1;
                sum += input[right];
            }else if(sum == target){
                output = Math.min(right - left +1, output);
                right += 1;
                sum += input[right];
            }else if(sum > target){
                output = Math.min(right - left +1, output);
                sum -= input[left];
                left += 1;
            }
        }

        if(output > n) output = 0;
        System.out.println(output);
    }
}
