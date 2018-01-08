package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 18..
 */
public class BJ1963 {
    public static boolean[] prime = new boolean[10001];
    public static void main(String[] args){

        for(int i = 0; i <= 10000; ++i){
            if(prime[i] == false){
               for(int j = i * i; j <= 10000; j+=i){
                   prime[j] = true;
               }
            }
        }

        for(int i = 0 ; i <= 10000; ++i){
            prime[i] = !prime[i];
        }

        Scanner scanner = new Scanner(System.in);
        int testcase = scanner.nextInt();
        for(int tc = 0; tc < testcase; ++tc){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] dist = new int[10001];
            boolean[] check = new boolean[10001];
            Queue<Integer> queue = new LinkedList<>();

            dist[n] = 0;
            check[n] = true;
            queue.offer(n);
            while(!queue.isEmpty()){
                int now = queue.poll();
                for(int i = 0; i < 4; ++i){//4자리수
                    for(int j = 0; j <= 9; j++){//0부터 9까지
                        int next = change(now, j, j);
                        if(next != -1){//앞의 첫자리가 0으로 시작하는 경우
                            if(prime[next] && check[next] == false){
                                queue.offer(next);
                                dist[next] = dist[now] + 1;
                                check[next] = true;
                            }
                        }
                    }
                }
            }

        }
    }
    //now의 index 위치의 수를 digit으로 바꾼다.
    private static int change(int now, int index, int digit) {
        if(index == 0 && digit == 0) return -1;
        char[] s = String.valueOf(now).toCharArray();
        s[index] = (char) (digit + '0');
        return Integer.parseInt(new String(s));
    }
}
