package baekjoon.java;

import java.util.*;
class BJ1744 {
    static long getMax(int[] inputs){
        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        int zero = 0;
        int one = 0;


        for(int i = 0; i < inputs.length; ++i){
            if(inputs[i] == 1) one += 1;
            else if(inputs[i] > 0) plus.add(inputs[i]);
            else if(inputs[i] < 0) minus.add(inputs[i]);
            else zero += 1;
        }

        long output = one;

        Collections.sort(plus);
        Collections.reverse(plus);
        if(plus.size() % 2 == 1){
            plus.add(1);
        }

        for(int i = 0; i < plus.size() ; i += 2){
            output += plus.get(i) * plus.get(i + 1);
        }

        Collections.sort(minus);

        if(minus.size() % 2 == 1){
           if(zero > 0) minus.add(0);
           else minus.add(1);
        }

        for(int i = 0; i < minus.size(); i += 2){
            output += minus.get(i) * minus.get(i + 1);
        }

        return output;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inputs = new int[n];
        for(int i = 0; i < n; ++i){
            inputs[i] = sc.nextInt();
        }

        long output = getMax(inputs);
        System.out.println(output);
    }
}
