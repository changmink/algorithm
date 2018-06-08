package crackInterview.chap1test;

import crackInterview.chap1.*;
import org.junit.*;
import static org.junit.Assert.*;
/**
 * Created by changmin on 2018. 6. 6..
 */
public class TestP3 {
    String input = "Do you like pizza?";
    String testOutput = "Do%20you%20like%20pizza?";

    @Test
    public void test_getSize(){
        String output = new P3().getURL(input, testOutput.length());
        assertEquals(output, testOutput);
    }

    @Test
    public void test_noSizeStringBuilder(){
        String output = new P3().getURL(input);
        assertEquals(output, testOutput);
    }

    @Test
    public void test_noSizeCharArray(){
        String output = new P3().getURLLow(input);
        assertEquals(output, testOutput);
    }



}
