package crackInterview.chap1test;

import crackInterview.chap1.*;
import org.junit.*;
import static org.junit.Assert.*;
/**
 * Created by changmin on 2018. 6. 7..
 */
public class TestP8 {
    @Test
    public void test_가운데_0(){
        int[][] input = new int[][]{{1,2,3}, {1,0,1}, {2,2,2}};
        int[][] output = new int[][]{{1,0,3}, {0,0,0}, {2,0,2}};
        assertArrayEquals(output, new P8().zero(input));
    }

    @Test
    public void test_0이_없는_경우(){
        int[][] input = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        assertArrayEquals(input, new P8().zero(input));
    }

    @Test
    public void test_코너에_0(){
        int[][] input = new int[][]{{0,1,0}, {2,3,4}, {0,5,0}};
        int[][] output = new int[][]{{0,0,0}, {0,3,0}, {0,0,0}};
        assertArrayEquals(output, new P8().zero(input));
    }
}
