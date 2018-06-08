package baekjoon.java;

import java.util.*;
/**
 * Created by changmin on 2018. 3. 12..
 */
public class BJ2331 {
    static int pow(int value, int p){
        int output = 1;
        for(int j = 0; j < p; ++j){
            output *= value;
        }
        return output;
    }

    static int getValue(int a, int b){
        int output = 0;

        while(a > 0){
            output += pow(a % 10, b);
            a /= 10;
        }

        output += pow(a, b);
        return output;
    }

    static int getLength(int a, int b){
        List<Integer> list = new ArrayList<>();
        while(true) {
            if(!list.contains(a)) {
                list.add(a);
                a = getValue(a, b);
            }else{
                int index = list.lastIndexOf(a);
                return index;//제로 인덱스 이므로 그냥 리턴한다.
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(getLength(a, p));
    }
}
