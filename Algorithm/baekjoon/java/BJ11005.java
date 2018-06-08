package baekjoon.java;

import java.util.*;
public class BJ11005 {
    public static char table[];
    static{
        table = new char['Z' - 'A' + 1];
        for(int i = 0; i < 'Z' - 'A' + 1; ++i){
            table[i] = (char)('A' + i);
        }
    }
    public static String getBase(int n, int b){
        StringBuilder output = new StringBuilder();

        while(n != 0){
            int r = n % b;
            n = n / b;
            if(r > 9){
                char value = table[r - 10];
                output.append(value);
            }
            else {
                output.append(r);
            }
        }
        return output.reverse().toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        String output = getBase(n, b);
        System.out.println(output);
    }
}
