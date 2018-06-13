package crackInterview.chap2;

/**
 * Created by changmin on 2018. 6. 12..
 */
public class P3 {
    /**
     * 헤드가 아닌 제공되는 노드에만 접근이 가능, 처음과 끝사이의 노드를 제거, 마지막 노드이면 불가능
     */
    public boolean removeMiddle(Node node){
        if(node == null || node.next == null){
            return false;
        }
        Node nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
        return true;
    }
}
