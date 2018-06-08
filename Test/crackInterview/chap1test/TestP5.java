package crackInterview.chap1test;

import org.junit.*;
import static org.junit.Assert.*;
import crackInterview.chap1.P5;
/**
 * Created by changmin on 2018. 6. 6..
 */
public class TestP5 {
    @Test
    public void test_edit2_false(){
        boolean output = new P5().differ1("toma", "somi");
        assertEquals(output, false);
    }
    @Test
    public void test_edit1_true(){
        boolean output = new P5().differ1("soma", "somi");
        assertEquals(output, true);
    }
    @Test
    public void test_add1_true(){
        boolean output = new P5().differ1("som", "somi");
        assertEquals(output, true);
    }

    @Test
    public void test_add2_false(){
        boolean output = new P5().differ1("so", "somi");
        assertEquals(output, false);
    }

    @Test
    public void test_remove1_true(){
        boolean output = new P5().differ1("somi", "som");
        assertEquals(output, true);
    }

    @Test
    public void test_remove2_false(){
        boolean output = new P5().differ1("somi", "so");
        assertEquals(output, false);
    }

}

