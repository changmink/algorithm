import ETC.*;
import org.junit.*;

/**
 * Created by changmin on 2017. 12. 17..
 */
public class TestPermutaion {
    @Test
    public void testNextPermutation(){
        Permutaion p = new Permutaion();
        int[] input = new int[]{7,2,3,1,6,5,4};
        boolean output = p.nextPermutation(input);
        Assert.assertEquals(output, true);

        input = new int[]{7,6,5,4,3,2,1};
        output = p.nextPermutation(input);
        Assert.assertEquals(output, false);
    }

    @Test
    public void testPrevPermutation(){
        Permutaion p = new Permutaion();
        int[] input = new int[]{7,2,3,1,6,5,4};
        boolean output = p.prevPermutation(input);
        Assert.assertEquals(output, true);

        input = new int[]{1,2,3,4};
        output = p.prevPermutation(input);
        Assert.assertEquals(output, false);
    }
}
