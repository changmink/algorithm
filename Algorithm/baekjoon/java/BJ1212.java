package baekjoon.java;

import java.util.*;

public class BJ1212 {
    static String getBase8to2(char oct){
        StringBuilder output = new StringBuilder();
        int value = oct - '0';

        while(value != 0){
            int r = value % 2;
            value /= 2;
            output.append(r);
        }
        return output.reverse().toString();
    }

    static String getBase8to2(String oct){
        StringBuilder output = new StringBuilder();

        output.append(getBase8to2(oct.charAt(0)));

        for(int i = 1; i < oct.length(); ++i){
            String binary = getBase8to2(oct.charAt(i));

            int pad = 3 - binary.length();
            for(int j = 0; j < pad; ++j){
                output.append(0);
            }

            output.append(binary);
        }

        int zero = 0;
        for(int i = 0; i < output.length(); ++i){
            if(output.charAt(i) == '0'){
                zero += 1;
            }else{
                break;
            }
        }

        String outputValue = output.toString()
                                    .substring(zero);

        if(outputValue.length() == 0)
            return "0";

        return outputValue;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println(getBase8to2(sc.nextLine()));
    }
}
