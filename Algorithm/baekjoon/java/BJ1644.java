package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 5..
 */
import java.util.*;
public class BJ1644 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] c = new boolean[n + 1];
        List<Integer> p = new ArrayList<>();

        for(int i = 2; i <= n; ++i){
            if(!c[i]){
                p.add(i);
                for(int j = i * 2; j <= n; j+=i){
                    c[j] = true;
                }
            }
        }

        int left = 0;
        int right = 0;
        int sum = p.size() == 0 ? 0 : p.get(0);
        int output = 0;

        while(left <= right && right < p.size()){
            if(sum <= n){
                if(sum == n){
                    output += 1;
                }
                right++;
                if(right < p.size()){
                    sum += p.get(right);
                }
            }else{
                sum -= p.get(left++);
            }
        }

        System.out.println(output);
    }
}
