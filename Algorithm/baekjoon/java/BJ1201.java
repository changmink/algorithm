package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 11..
 */
import java.text.*;
import java.util.*;
public class BJ1201 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      if(m + k - 1 <= n && n <= m*k){
         int[] input = new int[n];

         for(int i = 0; i < n; ++i){
            input[i] = i + 1;
         }

         ArrayList<Integer> group = new ArrayList<Integer>();
         //k크기의 부분 넣기
         group.add(0);
         group.add(k);
         n -= k;
         m -= 1;
         int size = (m == 0) ? 1 : n / m;
         int r = (m == 0) ? 0 : n % m;

         for (int i=0; i<m; i++) {
            //마지막 인덱스 + 크기 + 1(n이 m으로 나누어 떨어지지 않는 경우)
            group.add(group.get(group.size()-1) + size + (r > 0 ? 1 : 0));
            //m으로 나눈 나머지 이므로 다음은 m-1이 되므로 나머지도 빼준다.
            if (r > 0) {
               r -= 1;
            }
         }
         
         for (int i=0; i<group.size()-1; i++) {
            int begin = group.get(i);
            int end = group.get(i+1)-1;
            while (begin < end) {
               int temp = input[begin];
               input[begin] = input[end];
               input[end] = temp;
               begin += 1;
               end -= 1;
            }
         }

         for(int i = 0; i < n; ++i){
            System.out.print(input[i] + " ");
         }
      }else{
         System.out.println(-1);
      }
   }
}
