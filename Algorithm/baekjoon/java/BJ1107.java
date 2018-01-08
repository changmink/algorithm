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

        int n = scanner.nextInt();
        int b = scanner.nextInt();

        for(int i = 0; i < b; ++i){
            int button = scanner.nextInt();
            broken[button] = true;
        }

        int output = Math.abs(n - 100);

        //다 해보기
        for(int i =0; i <= 1000000; ++i){
            int c = i;
            int len = possible(c);
            if(len > 0){
                int press = Math.abs(c - n);
                if(output > len + press){
                    output = len + press;
                }
            }
        }

        System.out.println(output);
    }
}
