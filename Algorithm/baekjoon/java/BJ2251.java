package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 19..
 */

class Pair implements Comparable<Pair>{
    final int first;
    final int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair pair) {
        if(this.first < pair.first) return -1;
        if(this.first > pair.first) return 1;
        if(this.second < pair.second) return -1;
        if(this.second > pair.second) return 1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (first != pair.first) return false;
        return second == pair.second;
    }

    @Override
    public int hashCode() {
        int result = first;
        result = 31 * result + second;
        return result;
    }
}
public class BJ2251 {
    public static final int[] from = new int[]{0, 0, 1, 1, 2, 2};
    public static final int[] to = new int[]{1, 2, 0, 2, 0, 1};

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] input = new int [3];
        for(int i = 0; i < 3; ++i){
            input[i] = scanner.nextInt();
        }

        int sum = input[input.length - 1];
        boolean[][] check = new boolean[201][201];
        boolean[] output = new boolean[201];
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(0, 0));
        check[0][0] = true;
        output[input[input.length - 1]] = true;

        while(!queue.isEmpty()){
            int[] current = new int[3];
            Pair p = queue.poll();
            //각각 isQueen, b, c를 의미
            current[0] = p.first;
            current[1] = p.second;
            current[2] = sum - current[0] - current[1];

            //갈 수 있는건 위에서 정의한 6가지 경우
            for(int k = 0; k < 6; k++){
                int[] next = {current[0], current[1], current[2]};
                //물을 붓는다.
                next[to[k]] += next[from[k]];
                next[from[k]] = 0;

                //넘치면 나눈다
                if(next[to[k]] >= input[to[k]]){
                    next[from[k]] = next[to[k]] - input[to[k]];
                    next[to[k]] = input[to[k]];
                }

                //하지 않은 작업이라면 수행
                if(!check[next[0]][next[1]]){
                    check[next[0]][next[1]] = true;
                    queue.add(new Pair(next[0], next[1]));
                    if( next[0] == 0){
                        output[next[2]] = true;
                    }
                }
            }
        }

        for(int i = 0; i<=input[2]; ++i){
            if(output[i]){
                System.out.print(i + " ");
            }
        }
    }
}
