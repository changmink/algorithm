package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 19..
 */
public class BJ1759 {
    public static void go(int n, List<Character> alpha, String passowrd, int i){
        if(passowrd.length() == n){
            if(check(passowrd)){
                System.out.println(passowrd);
            }
        }

        return;
    }

    public static boolean check(String passoword) {
        int ja = 0;
        int mo = 0;
        for(char token : passoword.toCharArray()){
            if(token == 'a'){
                ++mo;
            }else{
                ++ja;
            }
        }
        return ja >= 2 && mo >= 1;
    }
}
