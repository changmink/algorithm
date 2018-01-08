package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 17..
 */
public class BJ1722 {
    public static long[] facto = new long[21];
    public static boolean[] used = new boolean[21];

    public static long getIndex(int[] inputs){
        long output = 0;
        for(int i  = 0;  i < inputs.length; ++i) {
            for(int j = 1; j < inputs[i]; j++) {
                if(used[j] == false) {
                    output += facto[inputs.length - i - 1];
                }
            }
            used[inputs[i]] = true;
        }
        return output + 1;//처음은 카운트 하지 않기 때문에 1을 더한다.
    }

    public static int[] getPermutation(int n, int index){
        int[] output = new int[n];
        for(int i = 0; i < n; ++i){
            for(int j = 1; j <= n; ++j){
                if(used[j] == true) continue;
                if(facto[n - i - 1] < index){
                    index -= facto[n - i - 1];
                }else{
                    output[i] = j;
                    used[j] = true;
                    break;
                }
            }
        }


        return output;
    }

    public static void main(String[] args){
        facto[0] = 1;

        for(int i = 1; i < 21; ++i){
            facto[i] = facto[i-1] * i;
        }

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int problem = scanner.nextInt();

        if(problem == 1){
            int value = scanner.nextInt();
            int[] output = getPermutation(n, value);
            for(int i = 0 ; i < n; ++i){
                System.out.print(output[i] + " ");
            }
        }else{
            int[] inputs = new int[n];
            for(int i = 0 ; i < n; ++i){
                inputs[i] = scanner.nextInt();
            }
            long output = getIndex(inputs);
            System.out.println(output);
        }


    }
}
