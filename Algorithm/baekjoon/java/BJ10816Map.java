package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 16..
 */
import java.util.*;
public class BJ10816Map {
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       Map<Integer, Integer> map = new HashMap<>();

       for(int i = 0; i < n; ++i){
           int value = sc.nextInt();
           if(map.containsKey(value)){
               map.put(value, map.get(value) + 1);
           }
           else{
               map.put(value, 1);
           }
       }

       StringBuilder output = new StringBuilder();
       int m = sc.nextInt();
       for(int i = 0; i < m; ++i){
           int value = sc.nextInt();

           if(map.containsKey(value)){
               output.append(map.get(value));
           }else{
               output.append(0);
           }

           output.append(" ");
       }

       System.out.println(output);
   }
}
