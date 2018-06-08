package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 18..
 */
public class BJ1107 {
    public static boolean[] broken = new boolean[10];
    public static int possible(int c){
        if(c == 0){
            return broken[0] ? 0 : 1;
        }

        int length = 0;
        while(c > 0){
            if(broken[c % 10]){
                return 0;
            }
            length += 1;
            c /= 10;
        }

        return length;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int channel = scanner.nextInt();
        int howManyBroken = scanner.nextInt();

        for(int i = 0; i < howManyBroken; ++i){
            int button = scanner.nextInt();
            broken[button] = true;
        }

        int output = Math.abs(channel - 100);

        //다 해보기 - 왜 100만? 50만이 아니고
        for(int i =0; i <= 1000000; ++i){
            int c = i;
            int len = possible(c);
            if(len > 0){
                int press = Math.abs(c - channel);
                if(output > len + press){
                    output = len + press;
                }
            }
        }

        System.out.println(output);
    }
//    public static int howManyPushButton(int target, boolean[] broken){
//        int ch = 100;
//        String targetString = String.valueOf(target);
//        int targetLength = targetString.length();
//        if(Math.abs(ch - target) <= targetLength){
//            return Math.abs(ch - target);
//        }
//
//        int value = Math.abs(ch - target);
//        int i = 0;
//
//        if(allBroken(broken))
//            return value + targetLength;
//        while(true){
//            if(valid(value - i, broken))
//                return value  - i + targetLength;
//
//            if(valid(value + i, broken))
//                return value  + i + targetLength;
//
//
//
//            i += 1;
//        }
//    }
//
//    private static boolean allBroken(boolean[] broken) {
//        for(boolean b : broken){
//            if(b == false) return false;
//        }
//        return true;
//    }
//
//    private static boolean valid(int target, boolean[] broken) {
//        String targetString = String.valueOf(target);
//        for(char ch : targetString.toCharArray()){
//            if(broken[ch-'0'])
//                return false;
//        }
//        return true;
//    }
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int channel = sc.nextInt();
//        int howManyBroken = sc.nextInt();
//        boolean[] broken = new boolean[10];
//        for(int i = 0; i < howManyBroken; ++i){
//            broken[sc.nextInt()] = true;
//        }
//
//        int output = howManyPushButton(channel, broken);
//        System.out.println(output);
//
//    }
}
