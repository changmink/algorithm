import org.junit.*;

/**
 * Created by changmin on 2018. 1. 26..
 */
import baekjoon.java.BJ2022;

import static org.junit.Assert.assertEquals;

public class TestBJ2022 {
    @Test
    public void testGetDist(){
        assertEquals(BJ2022.getDist(30, 40, 10), "26.033");
        assertEquals(BJ2022.getDist(12.619429, 8.163332, 3), "7.000");
        assertEquals(BJ2022.getDist(10, 10, 3), "8.000");
        assertEquals(BJ2022.getDist(10, 10, 1), "9.798");
    }
}
