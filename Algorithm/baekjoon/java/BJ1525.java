package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 19..
 */
public class BJ1525 {
    //상1 하0 좌3 우2
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args){
        int[] inputs = new int[9];
        Scanner scanner = new Scanner(System.in);
        int start = 0;
        int end = 123456789;
        int n = 3;
        for(int i = 0; i < n * n; ++i){
            int temp = scanner.nextInt();
            if(temp == 0) temp = 9;
            start = start * 10 + temp;
        }

        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> dist = new HashMap<>();

        queue.offer(start);
        dist.put(start, 0);

        while(!queue.isEmpty()){
            //문자열로 바꿔서 구한다.
            int nowNumber = queue.poll();
            String now = Integer.toString(nowNumber);
            //9의 위치
            int z = now.indexOf('9');
            // 위치는 0,1,2 중 하나
            int x = z / 3;
            int y = z % 3;

            //4방향에 대해서 각각 구한다.
            for(int k = 0; k <4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n){
                    StringBuilder next = new StringBuilder(now);
                    char temp = next.charAt(x * 3 + y);
                    next.setCharAt(x * 3 + y, next.charAt(nx * 3 + ny));
                    next.setCharAt(nx * 3 + ny, temp);
                    int num = Integer.parseInt(next.toString());

                    if(!dist.containsKey(num)){
                        dist.put(num, dist.get(nowNumber) + 1);
                        queue.add(num);
                    }
                }
            }
        }

        if(dist.containsKey(end)){
            System.out.println(dist.get(end));
        }else {
            System.out.println(-1);
        }
    }
}
