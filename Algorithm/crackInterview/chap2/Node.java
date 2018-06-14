package crackInterview.chap2;

/**
 * Created by changmin on 2018. 6. 12..
 * 편의를 위해서 맴버를 public으로 사용
 */
public class Node<T>{
   public T data;
   public Node next;

   public Node() {
   }

   public Node(T data) {

      this.data = data;
   }

   public static String traverse(Node start){
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
