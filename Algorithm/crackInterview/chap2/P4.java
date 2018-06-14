package crackInterview.chap2;

/**
 * Created by changmin on 2018. 6. 14..
 */
public class P4 {
    //O(n), O(n)
    public Node divide(Node<Integer> node, int mid){
        if(node == null)
            return null;

        Node<Integer> newNode = new Node<>(node.data);
        Node<Integer> head = newNode;
        Node<Integer> tail = newNode;
        node = node.next;

        while(node != null){
            newNode = new Node<>(node.data);
            if(node.data < mid){
                newNode.next = head;
                head = newNode;
            }else{
                tail.next = newNode;
                tail = newNode;
            }
            node = node.next;
        }
        return head;
    }
}
