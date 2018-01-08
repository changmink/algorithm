package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 5..
 */
import java.util.*;
public class BJ2003 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n+1];
        for(int i = 0; i < n; ++i){
            a[i] = sc.nextInt();
        }
        int left = 0;
        int right = 0;
        int sum = a[0];
        int output = 0;
        while(left <= right && right < n){
            if(sum < s){
                right += 1;
                sum += a[right];
            }else if(sum == s){
                output += 1;
                right += 1;
                sum += a[right];
            }else if(sum > s){
                sum -= a[left];
                left++;
            }
        }

        System.out.println(output);
    }
}
