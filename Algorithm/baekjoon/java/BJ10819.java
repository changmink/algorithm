package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 18..
 */
public class BJ10819 {
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

    public static int cal(int[] input){
        int output = 0;
        for(int i = 1; i < input.length; ++i){
            output += Math.abs(input[i] - input[i-1]);
        }
        return output;
    }

    public static int maxDifference(int[] input){
        int output = 0;
        Arrays.sort(input);
        do{
            int temp = cal(input);
            output = Math.max(temp, output);
        }while(nextPermutation(input));

        return output;
    }

    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        int size = scanner.nextInt();

        int[] inputs = new int[size];
        for(int i = 0; i < size; ++i){
           inputs[i] = scanner.nextInt();
        }

        int output = maxDifference(inputs);
        System.out.println(output);
    }
}
