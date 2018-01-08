package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 18..
 */
public class BJ1697 {
    public static final int MAX = 10000000;

    public static int getFastestTime(int start, int end) {
        boolean[] check = new boolean[MAX];
        int[] dist = new int[MAX];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        check[start] = true;
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for(int i = 0; i < 3; ++i){
                boolean condition;
                int value = 0;

                if(i == 0){
                    value = now - 1;
                    condition = value >= 0;
                }else if(i == 1){
                    value = now + 1;
                    condition = value < MAX;
                }else{
                    value = 2 * now;
                    condition = value < MAX;
                }

                if(condition){
                    if(check[value] == false){
                        queue.add(value);
                        check[value] = true;
                        dist[value] = dist[now] + 1;
                    }
                }
            }
        }
        return dist[end];
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        int output = getFastestTime(start, end);
        System.out.println(output);
    }
}
