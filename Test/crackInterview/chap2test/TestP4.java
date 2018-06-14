package crackInterview.chap2test;

import crackInterview.chap2.*;
import org.junit.*;

/**
 * Created by changmin on 2018. 6. 14..
 */

public class TestP4 {
    Node a,b,c,d,e,f;

    @Before
    public void test_init(){
        a = new Node();
        a.data = 6;

        b = new Node();
        b.data = 4;

        c = new Node();
        c.data = 3;

        d = new Node();
        d.data = 5;

        e = new Node();
        e.data = 1;

        f = new Node();
        f.data = 9;

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
    }
    @Test
    public void test_배열_확인(){
        System.out.println(Node.traverse(a));
        Node output = new P4().divide(a, 4);
        System.out.println(Node.traverse(output));
    }
}
