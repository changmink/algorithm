package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 11..
 */
import java.util.*;
public class BJ1783 {
    public static long getMoving(int h, int w){
        if(h == 1){
            return 1;
        }else if(h == 2){
            return Math.min(w/2 + 1, 4);
        }else {
            if(w < 7){
                return Math.min(w, 4);
            }else{
                return w - 2;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        long output = getMoving(h, w);
        System.out.println(output);

    }
}
