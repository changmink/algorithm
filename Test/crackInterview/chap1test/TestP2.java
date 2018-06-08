package crackInterview.chap1test;

import crackInterview.chap1.*;
import org.junit.*;
import static org.junit.Assert.*;
/**
 * Created by changmin on 2018. 6. 6..
 */
public class TestP2 {
    @Test
    public void test_true(){
        boolean output = new P2().isPermution("ABC", "BCA");
        assertEquals(output, true);

    }

    @Test
    public void test_false(){
        boolean output = new P2().isPermution("ABC", "BBC");
        assertEquals(output, false);

    }
}
