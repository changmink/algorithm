package baekjoon.java;

import java.util.*;

public class BJ10815Set {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < n; ++i){
            set.add(sc.nextInt());
        }

        int m = sc.nextInt();
        StringBuilder output = new StringBuilder();

        for(int i = 0; i < m; ++i){
            int value = sc.nextInt();
            if(set.contains(value))
                output.append(1 + " ");
            else{
                output.append(0 + " ");
            }
        }

        System.out.println(output);

    }
}
