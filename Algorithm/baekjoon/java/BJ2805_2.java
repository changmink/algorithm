package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 1. 25..
 */
public class BJ2805_2 {
    static int getMaxHeight(int[] woods, int target){
        int max = Arrays.stream(woods).max().getAsInt();
        int mid = max / 2;
        int sum = getCutSum(woods, mid);
        if(sum < target){
            while(sum < target){
                mid = mid - 1;
                sum = getCutSum(woods, mid);
            }
            return mid;
        }else{
            while(sum >= target){
                mid += 1;
                sum = getCutSum(woods, mid);
            }
            return mid - 1;
        }
    }

    private static int getCutSum(int[] woods, int cutHeight) {
        int sum = 0;
        for(int wood : woods){
            if(wood - cutHeight > 0) sum += (wood - cutHeight);
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] woods = new int[n];
        int target = sc.nextInt();
        for(int i = 0; i < n; ++i){
            woods[i] = sc.nextInt();
        }
        int output = getMaxHeight(woods, target);
        System.out.println(output);
    }
}
