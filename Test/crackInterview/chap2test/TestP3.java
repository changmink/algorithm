package crackInterview.chap2test;

import org.junit.*;
import crackInterview.chap2.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by changmin on 2018. 6. 13..
 */
public class TestP3 {
    Node a,b,c,d;

    @Before
    public void test_init(){
        a = new Node();
        a.data = 1;

        b = new Node();
        b.data = 2;

        c = new Node();
        c.data = 3;

        d = new Node();
        d.data = 4;

        a.next = b;
        b.next = c;
        c.next = d;
    }

    @Test
    public void test_삭제_불가_길이가_1(){
        Node a = new Node();
        a.data = 1;

        boolean isSucess = new P3().removeMiddle(a);
        assertEquals(isSucess, false);
        assertEquals(traverse(a), "1");
    }

    @Test
    public void test_삭제_불가_길이가_0(){
        Node a = null;
        boolean isSucess = new P3().removeMiddle(a);
        assertEquals(isSucess, false);
        assertEquals(traverse(a), "");
    }

    @Test
    public void test_삭제_불가_입력이_마지막노드(){
        boolean isSuccess = new P3().removeMiddle(d);
        assertEquals(isSuccess, false);
        assertEquals(traverse(a), "1-2-3-4");
    }

    @Test
    public void test_삭제_가능_중간노드(){
        boolean isSuccess = new P3().removeMiddle(b);
        assertEquals(isSuccess, true);
        assertEquals(traverse(a), "1-3-4");
    }

    @Test
    public void test_삭제_가능_첫번째_노드(){
        boolean isSuccess = new P3().removeMiddle(a);
        assertEquals(isSuccess, true);
        assertEquals(traverse(a), "2-3-4");
    }

    public String traverse(Node start){
        if(start == null)
            return "";

        StringBuffer output = new StringBuffer();

        Node p = start;
        while(p.next != null){
            output.append(p.data);
            output.append('-');
            p = p.next;
        }

        output.append(p.data);

        return output.toString();
    }
}
