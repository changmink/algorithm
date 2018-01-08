package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 17..
 */
public class BJ10974 {
    public static boolean nextPermutation(int[] inputs){
        int i = inputs.length - 1;
        //뒤에서 부터 내림 차순이 안되는 i를 찾는다
        while(i > 0 && inputs[i-1] > inputs[i]) i -= 1;

        //마지막인 경우
        if(i <= 0) return false;

        //오름 차순이 안되는 j를 찾아 i와 바꾼다
        int j = inputs.length - 1;
        while(inputs[j] <= inputs[i-1]) j -= 1;

        int temp = inputs[i-1];
        inputs[i-1] = inputs[j];
        inputs[j] = temp;

        //스왑한다.
        j = inputs.length - 1;
        while(i < j){
            temp = inputs[i];
            inputs[i] = inputs[j];
            inputs[j] = temp;
            i += 1; j -= 1;
        }

        return true;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputs = new int[n];
        for(int i = 0 ;i < n; ++i){
            inputs[i] = i + 1;
            System.out.print(inputs[i] + " ");
        }
        System.out.println();
        while(nextPermutation(inputs)){
            for(int i = 0; i < n; ++i){
                System.out.print(inputs[i] + " ");
            }
            System.out.println();
        }
    }
}
