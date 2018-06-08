import org.junit.*;

/**
 * Created by changmin on 2018. 1. 26..
 */
import baekjoon.java.BJ1561;
import baekjoon.java.BJ1561_2;

public class TestBJ1561 {
    @Test
    public void testBJ1561(){
        int student = 2000000000;
        int m = 10000;
        int[] machine = new int[m];
        for(int i = 0; i < m; ++i){
            machine[i] = 1;
        }

        long output = BJ1561.findLastRide(student,m, machine);
        System.out.println(output);

        output = BJ1561_2.findFinalRide(machine, student);
        System.out.println(output);
    }
}
