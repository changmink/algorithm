package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 17..
 */
public class BJ10973 {
    public static boolean prevPermutation(int[] inputs){
        int i = inputs.length - 1;

        while(i > 0 && inputs[i-1] < inputs[i]) --i;

        if(i <= 0) return false;

        int j = inputs.length - 1;
        while(inputs[j] >= inputs[i-1]) --j;

        int temp = inputs[i-1];
        inputs[i-1] = inputs[j];
        inputs[j] = temp;

        j = inputs.length - 1;
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
        int[] inputs = new int[n];

        for(int i = 0; i < n; ++i){
            inputs[i] = scanner.nextInt();
        }

        if(prevPermutation(inputs)){
            for(int i = 0; i < n; ++i){
                System.out.print(inputs[i] + " ");
            }
        }else{
            System.out.println(-1);
        }

    }
}
