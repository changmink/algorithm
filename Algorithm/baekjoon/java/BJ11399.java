package baekjoon.java;

import java.util.*;

public class BJ11399 {

    public static int lineScheduleForWating(int n, int[] watingTimes){
       int output = 0;
       int accumulation = 0;

       Arrays.sort(watingTimes);

       for(int i = 0; i < watingTimes.length; ++i){
           accumulation += watingTimes[i];
           output += accumulation;
       }

       return output;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] watingTimes = new int[n];

        for(int i = 0; i < n; ++i){
            watingTimes[i] = scanner.nextInt();
        }

        int output = lineScheduleForWating(n, watingTimes);
        System.out.println(output);
    }

}
