package crackInterview.chap1test;

import crackInterview.chap1.*;
import org.junit.*;
import static org.junit.Assert.*;
/**
 * Created by changmin on 2018. 6. 6..
 */
public class TestP1 {
    @Test
    public void test_set_false(){
        boolean output = new P1().isUniqueCharString("pizza");
        assertEquals(output, false);
    }

    @Test
    public void test_set_true(){
       boolean output = new P1().isUniqueCharString("orange");
       assertEquals(output, true);
    }

    @Test
    public void test_set_empty(){
        boolean output = new P1().isUniqueCharString("");
        System.out.println(output);
    }

    @Test
    public void test_bitVector_false(){
        boolean output = new P1().isUniqueCharStringBitVector("pizza");
        assertEquals(output, false);
    }
    @Test
    public void test_bitVector_true(){
        boolean output =new P1().isUniqueCharString("orange");
        assertEquals(output, true);
    }
}
