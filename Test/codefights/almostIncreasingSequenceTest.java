package codefights;

import org.junit.*;

/**
 * Created by changmin on 2018. 6. 3..
 */
public class almostIncreasingSequenceTest {
    @Test
    public void test(){
        boolean output = new almostIncreasingSequence().almostIncreasingSequence(new int[]{1, 2, 3, 4, 3, 6});
        System.out.println(output);
    }
}
