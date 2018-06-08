package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 12..
 */
import java.util.*;
public class BJ2873 {
   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       int row = sc.nextInt();
       int col = sc.nextInt();

       int[][] input = new int[row][col];
       for(int i = 0; i < row; ++i){
           for(int j = 0; j < col; ++j){
              input[i][j] = sc.nextInt();
           }
       }
       StringBuilder output = new StringBuilder();

       if(row % 2 == 1){
           //지그 재그로 진행하면 목적지에 도착가능
           for(int i = 0; i < row; ++i){
               for(int j = 0; j < col-1; ++j){//이미 시작 위치가 칸을 점유하고 있으로 col-1이전 까지이다.
                   if(i % 2 == 0) output.append('R');
                   else output.append('L');
               }
               output.append('D');
           }

           //마지막 다운은 제거
           output.deleteCharAt(output.length() - 1);
       }else if(col % 2 == 1){
           //row는 자연스럽게 짝수 이므로 row-2 까지는 R-L-R-L 지그재그
           for(int i = 0; i < row-2; ++i){
               for(int j = 0; j < col-1; ++j){
                   if(i % 2 == 0) output.append('R');
                   else output.append('L');
               }
               output.append('D');
           }

           //이전 row가 존재 했다면 자연스럽게 row-2의 시작 위치이다.
           for(int i = 0; i < col-3; ++i){
               if(i % 2 == 0) output.append("DR");
               else output.append("UR");
           }

            //col-3이후에는 무조건 이렇게 진행 하면 된다
           output.append("DRURD");
       }else{
           //둘다 짝수인 경우 아직 구현 못함...
           //가장 작은 짝홀 or 홀짝 찾기
           int r = 0;
           int c = 1;
           for(int i = 0; i < row; ++i){
               for(int j = 0; j < col; ++j){
                   if((i+j) % 2 == 1 && input[r][c] > input[i][j]){
                       r = i;
                       c = j;
                   }
               }
           }


           //위에서부터 2줄을 확인 하면서 제외할 부분을 제거 한다.
           int lastHead = 0;
           for(int i = 0; i < row; i += 2){
               if(i < r-1){
                   for(int k = 0; k < 2; ++k) {
                       for (int j = 0; j < col -1; ++j) {
                           if(k % 2 == 0)output.append("R");
                           else output.append("L");
                       }
                       output.append("D");
                   }
                   continue;
               }
               else{
                   lastHead = i;
                   break;
               }
           }

           StringBuilder backRoute = new StringBuilder();
           int lastTail = row - 1;
           //아래서부터 2줄을 확인 하면서 제외할 부분을 제거 한다.
           for(int i = row-1; i >= 0; i -= 1){
               if(i > r + 2){
                   for(int k = 0; k < 2; ++k) {
                       for (int j = 0; j < col-1; ++j) {
                           if(k % 2 == 0)backRoute.append("R");
                           else backRoute.append("L");
                       }
                       backRoute.append("D");
                   }
                   continue;
               }
               else {
                   lastTail = i;
                   break;
               }
           }

           //중간 부분
           for(int i = 0; i < c; ++i){
               if(i % 2 == 0) output.append("DR");
               else output.append("UR");
           }
           for(int i = col-1; i > c; --i){
               if(i % 2 == 0) output.append("RD");
               else output.append("RU");
           }


           output.append(backRoute.reverse());
       }

       System.out.println(output.toString());

   }
}
