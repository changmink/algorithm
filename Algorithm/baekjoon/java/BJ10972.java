package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 17..
 */
public class BJ10972 {
    public static boolean nextPermutaion(int[] inputs, int n){
        int i = n - 1;
        while(i > 0 && inputs[i-1] > inputs[i]) i -= 1;

        if(i <= 0)
            return false;

        int j = n - 1;
        while(inputs[j] <= inputs[i-1]) j -= 1;

        int temp = inputs[i-1];
        inputs[i-1] = inputs[j];
        inputs[j] = temp;

        j = n - 1;
        while(i < j){
            temp = inputs[i];
            inputs[i] = inputs[j];
            inputs[j] = temp;

            ++i;
            --j;
        }

        return true;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];

        for(int i = 0; i < n; ++i){
            input[i] = scanner.nextInt();
        }

        if(nextPermutaion(input, n)){
           for(int i = 0; i < n; ++i){
               System.out.print(input[i] + " ");
           }
        }else{
            System.out.println("-1");
        }

    }
}
