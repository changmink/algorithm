package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 16..
 */

public class BJ1654 {
    public static int getMaxCableLength(int[] input, int k, int n){
        int max = Arrays.stream(input).max().getAsInt();
        int mid = max;

        while(mid > 1){
            int sum = 0;
            for(int i = 0; i < k; ++i){
                sum += input[i] / mid;
            }

            if(sum >= n)
                return mid;
            mid = mid/2;
        }

        return 1;
    }

    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);

       int k = scanner.nextInt();
       int n = scanner.nextInt();

       int[] inputs = new int[k];

       for(int i = 0; i < k; ++i){
           inputs[i] = scanner.nextInt();
       }

       int output = getMaxCableLength(inputs, k, n);
        System.out.println(output);
    }
}
