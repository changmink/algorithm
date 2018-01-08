package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 18..
 */
public class BJ10971 {
    public static boolean nextPermutation(int[] input){
        int i = input.length - 1;
        //뒤에서 부터 내림 차순이 안되는 i를 찾는다
        while(i > 0 && input[i-1] >= input[i]) i -= 1;

        //마지막인 경우
        if(i <= 0) return false;

        //오름 차순이 안되는 j를 찾아 i와 바꾼다
        int j = input.length - 1;
        while(input[j] <= input[i-1]) j -= 1;

        int temp = input[i-1];
        input[i-1] = input[j];
        input[j] = temp;

        //스왑한다.
        j = input.length - 1;
        while(i < j){
            temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            i += 1; j -= 1;
        }

        return true;
    }

    public static int minCost(int[][] cost){
        int[] path = new int[cost.length];
        for(int i = 0; i < path.length; ++i){
            path[i] = i;
        }
        int output = Integer.MAX_VALUE;
        do{
            int temp = getPathCost(path, cost);
            output = Math.min(temp, output);

        }while(nextPermutation(path));

        return output;
    }

    public static int getPathCost(int[] path, int[][] cost) {
        int output = 0;
        boolean ok = true;

        for(int i = 1; i < path.length; ++i){
            int value = cost[path[i-1]][path[i]];
            if(value == 0) ok = false;
            else output += value;
        }

        int value = cost[path[path.length - 1]][path[0]];

        if(ok && value != 0) {
            output += value;
            return output;
        }else{
            return Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[][] cost = new int[size][size];

        for(int i = 0; i < size; ++i){
            for(int j = 0; j < size; ++j){
                cost[i][j] = scanner.nextInt();
            }
        }

        int output = minCost(cost);
        System.out.println(output);
    }
}
