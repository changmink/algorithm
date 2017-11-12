package BaekJoon;

import java.io.*;
import java.util.*;

public class BJ1005 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException{

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());//

        for(int tc = 0; tc < testCase; ++tc){
            String[] in = br.readLine().split(" ");
            int numberOfBuiding = Integer.parseInt(in[0]);
            int numberOfRules =  Integer.parseInt(in[1]);

            int[][] graph = new int[numberOfBuiding + 1][numberOfBuiding + 1];
            int[] DP = new int[numberOfBuiding + 1];

            in = br.readLine().split(" ");
            int[] costs = new int[numberOfBuiding + 1];

            for(int i = 0; i < numberOfBuiding; ++i){
                costs[i+1] = Integer.parseInt(in[i]);
            }

            // 건설 순서 입력 및 그래프 생성
            int start = 0;
            int end = 0;


            for(int r = 0; r < numberOfRules; ++r){
                in = br.readLine().split(" ");
                start = Integer.parseInt(in[0]);
                end = Integer.parseInt(in[1]);
                graph[start][end] = 1;
            }

            int destnation = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();

            queue.offer(1);
            DP[1] = costs[1];

            while(!queue.isEmpty()){
                start = queue.poll();
                if(start == destnation)
                    break;
                for(end = 1; end < numberOfBuiding + 1; ++end){
                    if(start != end && graph[start][end] > 0){
                        queue.offer(end);
                        DP[end] = Math.max(DP[end], DP[start] + costs[end]);
                    }
                }

            }

            sb.append(DP[destnation] + "\n");
        }
        System.out.println(sb.toString());
    }
}
