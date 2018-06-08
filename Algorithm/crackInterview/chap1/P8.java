package crackInterview.chap1;

import java.util.*;

/**
 * Created by changmin on 2018. 6. 7..
 */
public class P8 {
    class Point{
        public int row;
        public int col;
        public Point(int r, int c){
            row = r;
            col = c;
        }
    }

    public int[][] zero(int[][] input){
        List<Point> zeros = new ArrayList<>();
        int[][] output = Arrays.copyOf(input, input.length);
        for(int i = 0; i < input.length; ++i){
            output[i] = Arrays.copyOf(input[i], input[0].length);
        }

        for(int row = 0; row < input.length; ++row){
            for(int col = 0; col < input.length; ++col){
                if(input[row][col] == 0){
                    zeros.add(new Point(row, col));
                }
            }
        }

        for(Point p: zeros){
            for(int i = 0; i < input.length; ++i){
                output[i][p.col] = 0;
            }

            for(int i = 0; i < input[0].length; ++i){
                output[p.row][i] = 0;
            }
        }

        return output;
    }
}
