package crackInterview.chap2;

/**
 * Created by changmin on 2018. 6. 14..
 */
public class P5 {
    public Node<Integer> sumNodeReverse(Node<Integer> h1, Node<Integer> h2){
        if(h1 == null && h2 == null){
            return null;
        }else if(h1 == null){
            return h2;
        }else if(h2 == null){
            return h1;
        }

        Node p, h3;
        int result = h1.data + h2.data;
        int value = result % 10;
        int carry = result / 10;
        Node<Integer> n = new Node<>();
        n.data = value;
        p = h3 = n;
        h1 = h1.next;
        h2 = h2.next;

        while(h1 != null && h2 != null){
            result = carry + h1.data + h2.data;
            value = result % 10;
            carry = result / 10;

            n = new Node<>();
            n.data = value;

            p.next = n;
            p = p.next;

            h1 = h1.next;
            h2 = h2.next;
        }

        while(h1 != null){
            result = carry + h1.data;
            value = result % 10;
            carry = result / 10;

            n = new Node<>();
            n.data = value;
            p.next = n;
            p = p.next;

            h1 = h1.next;
        }

        while(h2 != null){
            result = carry + h2.data;
            value = result % 10;
            carry = result / 10;

            n = new Node<>();
            n.data = value;
            p.next = n;
            p = p.next;

            h2 = h2.next;
        }


        return h3;
    }

}
