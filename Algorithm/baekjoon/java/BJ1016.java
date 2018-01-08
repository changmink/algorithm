package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 26..
 */
import java.util.*;

public class BJ1016 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long min = scanner.nextLong();
        long max = scanner.nextLong();
        long diff = max - min;
        boolean[] check = new boolean[(int)diff + 1];

        for(long i = 2; i * i <= max; ++i){
            long start = i * i - min % (i * i);
            if(start == i * i){
                start = 0;
            }

            for(long j = start; j <= max - min; j += i * i){
                //해당 배수는 지운다.
                check[(int)j] = true;
            }
        }

        int output = 0;
        for(int i = 0; i < diff; ++i){
            if(check[i] == false){
                output += 1;
            }
        }

        System.out.println(output);
    }
}
