import ETC.*;
import org.junit.*;

/**
 * Created by changmin on 2017. 12. 8..
 */
public class TestStringAdd {
    @Test
    public void testStringAdd(){
        int output = new StringAdd().stringAdd("123", "45");
        Assert.assertEquals(output, 168);
    }
}
