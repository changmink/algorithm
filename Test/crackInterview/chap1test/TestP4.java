package crackInterview.chap1test;

/**
 * Created by changmin on 2018. 6. 6..
 */
import org.junit.*;
import static org.junit.Assert.*;
import crackInterview.chap1.P4;
public class TestP4 {
    @Test
    public void test_simple_pal_true() {
        String input = "rotator";
        boolean output = new P4().isPal(input);
        assertEquals(output, true);
    }

    @Test
    public void test_simple_pal_false(){
        String input = "tomato";
        boolean output = new P4().isPal(input);
        assertEquals(output, false);
    }

    @Test
    public void test_space_pal_true(){
        String input = "다들 잠들다";
        boolean output = new P4().isPal(input);
        assertEquals(output, true);
    }

    @Test
    public void test_space_pal_false(){
        String input = "치킨 피자";
        boolean output = new P4().isPal(input);
        assertEquals(output, false);
    }

    @Test
    public void test_odd_1_false(){
        String input = "여보 보여?";
        boolean output = new P4().isPal(input);
        assertEquals(output, false);
    }

    @Test
    public void test_even_false(){
        String input = "오어오어";
        boolean output = new P4().isPal(input);
        assertEquals(output, false);
    }
}
