package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 23..
 */
public class BJ11279 {
    public static void main(String[] args){
        class Compare implements Comparator<Integer>{
            public int compare(Integer one, Integer two){
                return two.compareTo(one);
            }
        }
        Scanner scanner = new Scanner(System.in);
        Compare cmp = new Compare();
        PriorityQueue<Integer> q = new PriorityQueue<>(1, cmp);
        int n = scanner.nextInt();

        while(n -- > 0){
            int x = scanner.nextInt();
            if(x == 0){//0이면 넣기
                if(q.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(q.poll());
                }
            }else{
                q.offer(x);
            }
        }
    }
}
