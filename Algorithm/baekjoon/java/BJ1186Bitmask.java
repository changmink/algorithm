package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 21..
 */
import java.util.*;

public class BJ1186Bitmask {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int input[] = new int[n];

        for(int i = 0; i < n; ++i){
            input[i] = scanner.nextInt();
        }

        int output = getCase(n, input,target);
    }

    public static int getCase(int n, int[] input, int target) {
        int output = 0;
        int sum = 0;

        for(int i = 1; i < (1 << n); ++i){
            for(int k = 0; k < n; ++k) {
                if (isExist(i, k)){
                    sum += input[k];
                }
            }

            if(sum == target){
                output += 1;
            }
        }

        return output;
    }

    //value에 k가 존재하는지 여부를 비트마스크로 확인
    public static boolean isExist(int value, int k){
        return (value & (1 << k)) != 0;
    }
}
