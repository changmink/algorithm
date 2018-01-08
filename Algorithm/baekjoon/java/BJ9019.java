package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 19..
 */
public class BJ9019 {
    public final static int MAX = 100001;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testcase = scanner.nextInt();

        for(int tc = 0; tc < testcase; ++tc){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            Queue<Integer> queue = new LinkedList<>();
            boolean[] check = new boolean[MAX];
            int[] dist = new int[MAX];
            int[] from = new int[MAX];
            char[] how = new char[MAX];

            queue.offer(a);
            dist[a] = 0;
            check[a] = true;
            from[a] = -1;

            while(!queue.isEmpty()){
                int now = queue.poll();

                for(int i = 0; i < 4; ++i){
                    int next;
                    boolean condition;
                    char operation;

                    if(i == 0){
                        operation = 'D';
                        next = (now * 2) % 10000;
                    }else if(i == 2){
                        operation = 'S';
                        next = (now - 1) >= 0 ? now - 1 : 9999;
                    }else if(i == 3){
                        operation = 'L';
                        next = (now % 1000) * 10 + now / 1000;
                    }else{
                        operation = 'R';
                        next = (now / 10) + (now % 10) * 1000;
                    }

                    if(check[next] == false) {
                        check[next] = true;
                        queue.offer(next);
                        dist[next] = dist[now] + 1;
                        from[next] = now;
                        how[next] = operation;
                    }
                }
            }

            StringBuilder stb = new StringBuilder();
            while(a != b){
                stb.append(how[b]);
                b = from[b];
            }

            System.out.println(stb.toString());


        }
    }
}
