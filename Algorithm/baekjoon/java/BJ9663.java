package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 19..
 */
public class BJ9663 {
    public static int n;
    public static int output = 0 ;
    //체스판의 퀸이 있는지 여부
    public static boolean[][] isQueen = new boolean[15][15];
    public static boolean check(int row, int col){

        //위에서 아래 체크
        for(int i = 0; i < n; ++i){
            if(i == row) continue;
            if(isQueen[i][col]){
                return false;
            }
        }
        // 왼쪽 위 대각선
        int x = row - 1;
        int y = col - 1;
        while( x >=0 && y >= 0){
            if(isQueen[x][y] == true){
                return false;
            }
            x -= 1;
            y -= 1;
        }
        //오른쪽 아래 대각선
        x = row - 1;
        y = col + 1;
        while(x >=0 && y < n){
            if(isQueen[x][y] == true) {
                return false;
            }
            x -= 1;
            y += 1;
        }

        return true;
    }

    public static void calc(int row){
        if(row == n){
            output += 1;
        }

        //각 row에 대해서 col을 확인 한다
        for(int col = 0; col < n; ++col){
            isQueen[row][col] = true;
            if(check(row, col)){
                calc(row+1);//퀸이 없으면 다음으로
            }
            isQueen[row][col] = false;
        }
    }


    // 성능 개선 부분  N ^ (N ^ 2) 에서 N ^ N 로 개선, 정답을 누적함
    public static boolean[] checkCol = new boolean[15];
    public static boolean[] checkDig = new boolean[40];
    public static boolean[] checkDig2 = new boolean[40];

    //배열을 통해서 3번만 검사 O(1)
    public static boolean check2(int row, int col){
       if(checkCol[col]) return false;
       if(checkDig[row+col])return false;
       if(checkDig2[row-col+n]) return false;
       return true;
    }

    int calc2(int row){
        if(row == n){
            return 1;
        }
        int cnt = 0;
        for(int col = 0; col< n; col++){
            if(check(row, col)){
                checkDig[row+col] = true;
                checkDig2[row+col+n] = true;
                checkCol[col] = true;
                isQueen[row][col] = true;

                cnt += calc2(row+1);

                checkDig[row+col] = false;
                checkDig2[row+col+n] = false;
                checkCol[col] = false;
                isQueen[row][col] = false;
            }
        }

        return cnt;
    }
}
