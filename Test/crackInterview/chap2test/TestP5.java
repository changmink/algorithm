package crackInterview.chap2test;

import crackInterview.chap2.*;
import org.junit.*;

/**
 * Created by changmin on 2018. 6. 14..
 */
public class TestP5 {

    @Before
    public void init(){

    }

    @Test
    public void test_거꾸로_입력_자리수가_같은경우(){
        Node a,b,c,d,e,f;
        a = new Node(7);
        b = new Node(1);
        c = new Node(6);
        a.next = b;
        b.next = c;

        d = new Node(5);
        e = new Node(9);
        f = new Node(2);

        d.next = e;
        e.next = f;

        Node<Integer> output = new P5().sumNodeReverse(a, d);
        System.out.println(Node.traverse(output));
    }

    @Test
    public void test_거꾸로_입력_자리수가_다른경우_앞이_작음(){
        Node a,b,c,d,e;
        a = new Node(7);
        b = new Node(1);
        c = new Node(6);
        a.next = b;
        b.next = c;

        d = new Node(5);
        e = new Node(9);

        d.next = e;

        Node<Integer> output = new P5().sumNodeReverse(a, d);
        System.out.println(Node.traverse(output));
    }

    @Test
    public void test_거꾸로_입력_자리수가_다른경우_뒤가_작음(){
        Node a,b,d,e,f;
        a = new Node(7);
        b = new Node(1);

        a.next = b;

        d = new Node(5);
        e = new Node(9);
        f = new Node(2);

        d.next = e;
        e.next = f;

        Node<Integer> output = new P5().sumNodeReverse(a, d);
        System.out.println(Node.traverse(output));
    }
}
