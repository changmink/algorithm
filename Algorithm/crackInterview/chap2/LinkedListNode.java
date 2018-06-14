package crackInterview.chap2;

/**
 * Created by changmin on 2018. 6. 14..
 */
public class LinkedListNode<T> {
    public Node<T> head;

    public LinkedListNode() {
        this.head = null;
    }

    public class Node<T>{
        public T data;
        public Node<T> next;
    }
    public void add(T data){
        Node n = new Node();
        n.data = data;
        if(head == null){
            head = n;
        }
        else{
            n.next = head;
            head = n;
        }
    }

    public void remove(){
        if(head == null) return;
        head = head.next;
    }

    public void remove(int index){
        Node p = head;
        int count = 0;
        while(p.next != null && count < index){
            p = p.next;
            count += 1;
        }
        if(p == null || count != index) return;
        p.next = p.next.next;
    }

    public static String traverse(crackInterview.chap2.Node start){
        if(start == null)
            return "";

        StringBuffer output = new StringBuffer();

        crackInterview.chap2.Node p = start;
        while(p.next != null){
            output.append(p.data);
            output.append('-');
            p = p.next;
        }

        output.append(p.data);

        return output.toString();
    }
}
