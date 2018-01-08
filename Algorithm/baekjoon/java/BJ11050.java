package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 27..
 */
import java.util.*;
public class BJ11050 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int output = facto(n) / (facto(k) * facto(n-k));
        System.out.println(output);
    }
    public static int facto(int n){
        if(n <= 1)
            return 1;
        else return n * facto(n-1);
    }
}
