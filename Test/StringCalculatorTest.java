import ETC.*;
import org.junit.*;


public class StringCalculatorTest {
    @Test
    public void testStringAdd(){
        int output = new StringCalculator().add("123", "45");
        Assert.assertEquals(output, 168);
    }
}
