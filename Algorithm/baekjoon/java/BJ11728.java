package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 14..
 */
public class BJ11728 {
    public static String merge(int[] input1, int[] input2){
        int index1 = 0;
        int index2 = 0;
        StringBuilder output = new StringBuilder();

        while(index1 < input1.length && index2 < input2.length){
            if(input1[index1] < input2[index2]){
                output.append(input1[index1++]);
                output.append(" ");
            }
            else{
                output.append(input2[index2++]);
                output.append(" ");
            }
        }

        while(index1 < input1.length){
            output.append(input1[index1++]);
            output.append(" ");
        }

        while(index2 < input2.length){
            output.append(input2[index2++]);
            output.append(" ");
        }


        return output.toString();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int size1 = scanner.nextInt();
        int size2 = scanner.nextInt();

        int[] input1 = new int[size1];
        int[] input2 = new int[size2];

        for(int i = 0; i < size1; ++i){
            input1[i] = scanner.nextInt();
        }

        for(int i = 0; i < size2; ++i){
            input2[i] = scanner.nextInt();
        }

        String output = merge(input1, input2);
        System.out.println(output);
    }
}
