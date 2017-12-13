import ETC.*;
import org.junit.*;

/**
 * Created by changmin on 2017. 12. 8..
 */
public class CaseChangerTest {
    @Test
    public void testSnakeToCamel(){
        String output = new CaseChanger().snakeToCamel("snake");
        Assert.assertEquals(output, "snake");

        output = new CaseChanger().snakeToCamel("snake_to_camel");
        Assert.assertEquals(output, "snakeToCamel");
    }
}
