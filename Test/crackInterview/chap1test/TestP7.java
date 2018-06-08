package crackInterview.chap1test;

import crackInterview.chap1.*;
import org.junit.*;
import static org.junit.Assert.*;
/**
 * Created by changmin on 2018. 6. 7..
 */
public class TestP7 {
    @Test
    public void test(){
        int[][] input = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] output = new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertArrayEquals(new P7().rotateSimple(input), output);
    }
}
