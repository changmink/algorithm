package baekjoon.java;

/**
 * Created by changmin on 2018. 2. 27..
 */
import java.io.*;
import java.util.*;

public class BJ2089 {
    static String negativeBase2(int n){
        StringBuilder output = new StringBuilder();
        while(n != 0){
            int r = Math.abs(n % -2);
            n = (int) Math.ceil(n / -2.0);
            output.append(r);
        }
        return output.reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(negativeBase2(Integer.valueOf(reader.readLine())));
    }
}
