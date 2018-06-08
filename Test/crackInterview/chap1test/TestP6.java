package crackInterview.chap1test;

import crackInterview.chap1.*;
import org.junit.*;
import static org.junit.Assert.*;
/**
 * Created by changmin on 2018. 6. 6..
 */
public class TestP6 {
    @Test
    public void test_입력과_출력이_같은_경우(){
        String input = "abcd";
        String output = new P6().runLength(input);
        assertEquals(input, output);
    }

    @Test
    public void test_입력보다_출력이_작은경우(){
        String input = "aaabbcdefg";
        String testOutput = "a3b2cdefg";

        String output = new P6().runLength(input);
        assertEquals(output, testOutput);
    }

    @Test
    public void test_입력보다_출력이_큰경우(){
        String input = "aabbccd";
    }
}
