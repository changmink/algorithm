package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 12..
 */
import java.util.*;
public class BJ1080 {
   static int change(boolean[][] input, boolean[][] output){
      int count = 0;

      for(int i = 0; i < input.length - 2; ++i){
         for(int j = 0; j < input[0].length - 2; ++j){
            if(input[i][j] != output[i][j]){
               flip(input, i , j);
               count += 1;
            }
         }
      }

      for(int i = 0 ; i < input.length; ++i){
         for(int j = 0; j < input[0].length; ++j){
            if(input[i][j] != output[i][j]){
               return -1;
            }
         }
      }

      return count;
   }

   static void flip(boolean[][] input, int row, int col){
      for(int i = row; i < row + 3; ++i){
         for(int j = col; j < col + 3; ++j){
            if(i < input.length && j < input[0].length){
               input[i][j] = !input[i][j];
            }
         }
      }
   }

   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int row = sc.nextInt();
      int col = sc.nextInt();
      sc.nextLine();

      boolean input[][] = new boolean[row][col];
      boolean output[][] = new boolean[row][col];

      for(int i = 0; i < row; ++i){
         String in = sc.nextLine();
         for(int j = 0; j < col; ++j){
             if(in.charAt(j) == '1'){
                input[i][j] = true;
             }
         }
      }

      for(int i = 0; i < row; ++i){
         String in  = sc.nextLine();
         for(int j = 0; j < col; ++j){
             if(in.charAt(j) == '1') {
                output[i][j] = true;
             }
         }
      }

      int result = change(input, output);
      System.out.println(result);
   }
}
