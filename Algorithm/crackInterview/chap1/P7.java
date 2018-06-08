package crackInterview.chap1;

/**
 * Created by changmin on 2018. 6. 7..
 */
public class P7 {
    public int[][] rotateSimple(int[][] input){
        int n = input.length;
        int[][] output = new int[n][n];

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                output[j][n-1-i] = input[i][j];
            }
        }

        return output;
    }
    // 별도의 배열 없이 수행하기
}
