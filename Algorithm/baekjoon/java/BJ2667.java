package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 3. 14..
 */
public class BJ2667 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[][] input = new int[n][];
        for(int i = 0; i < n; ++i){
            int[] row = Arrays.stream(sc.nextLine()
                                        .split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            input[i] = row;
        }

        int[] counts = label(input);

        //단지의 수(2부터 칠하기 때문에 1은 지운다.)
        System.out.println(color - 1);


//        for(int i = 0; i < input.length; ++i){
//            for(int j = 0; j < input[0].length; ++j){
//                System.out.print(input[i][j]);
//            }
//            System.out.println();
//        }

        for(int count : counts){
            System.out.println(count);
        }
    }
    public static int color = 1;
    public static int count = 0;
    public static int[] label(int[][] input){
        List<Integer> counts = new ArrayList<>();
        for(int i = 0; i < input.length; ++i){
            for(int j = 0; j < input[0].length; ++j){
                if(input[i][j] == 1){
                    color += 1;
                    count = 0;
                    floodFill(input,  i, j, color);
                    counts.add(count);
                }
            }
        }

        return counts.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    private static void floodFill(int[][] input, int x, int y, int color) {
        if(x < 0 || y < 0 || x >= input.length || y >= input[0].length || input[x][y] > 1 || input[x][y] <= 0){
            return;
        }

        input[x][y] = color;
        count += 1;
        floodFill(input, x - 1, y, color);
        floodFill(input, x , y - 1, color);
        floodFill(input, x + 1, y, color);
        floodFill(input, x , y + 1, color);
    }
}
