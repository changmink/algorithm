package baekjoon.java;
import java.util.*;

class BJ2263 {
    public static int[] inorder;
    public static int[] postorder;
    public static StringBuilder output;
    public static Map<Integer, Integer> table;

    public static void solve(int inStart, int inEnd, int postStart, int postEnd){
        if(postStart > postEnd || inStart > inEnd){
            return;
        }

        int root = postorder[postEnd];
        output.append(root + " ");

        int rootIndex = table.get(root);
        int leftSize = rootIndex - inStart;

        //L부분
        solve(inStart, rootIndex - 1, postStart, postStart + leftSize - 1);
        //R부분
        solve(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
    }
    public static void main(String[] args) {
        output = new StringBuilder();
        //Map을 사용 가능한 이유는 각노드는 다른 값을 가지기 때문이다.
        table = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        inorder = new int[n];
        postorder = new int[n];

        for(int i = 0; i < n; ++i){
            inorder[i] = sc.nextInt();
        }

        for(int i = 0; i < n; ++i){
            postorder[i] = sc.nextInt();
        }

        for(int i = 0; i < n; ++i){
            table.put(inorder[i], i);
        }

        int inStart = 0;
        int postStart = 0;
        int inEnd = n - 1;
        int postEnd = n - 1;

        solve(inStart, inEnd, postStart, postEnd);

        System.out.println(output);
    }
}
//import java.util.*;
//
///**
// * Created by changmin on 2017. 12. 15..
// */
//public class BJ2263 {
//
//    public static int[] inorder;
//    public static int[] postorder;
//    public static int[] inorderPos = new int[100001];
//    public static StringBuilder output = new StringBuilder();
//
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        int inStart = 0;
//        int inEnd = 3;
//        int postStart = 0;
//        int postEnd = 3;
//
//
//        int numberOfNode = scanner.nextInt();
//        inorder = new int[numberOfNode];
//        postorder = new int[numberOfNode];
//        postEnd = inEnd = numberOfNode - 1;
//
//        for(int i = 0; i < numberOfNode; ++i)
//            inorder[i] = scanner.nextInt();
//
//        for(int i = 0; i < numberOfNode; ++i){
//            postorder[i] = scanner.nextInt();
//        }
//
//        for(int i = 0; i < numberOfNode; ++i){
//            inorderPos[inorder[i]] = i;
//        }
//
//        solve(inStart,inEnd,postStart,postEnd);
//        System.out.println(output.toString());
//
//    }
//
//    public static void solve(int inStart, int inEnd, int postStart, int postEnd) {
//        //탈출 조건
//        if(inStart > inEnd || postStart > postEnd)
//            return;
//
//        int root = postorder[postEnd];
//        output.append(root + " ");
//        int rootIndex = inorderPos[root];
//        int leftSize = rootIndex - inStart;
//
//        solve(inStart, rootIndex - 1, postStart, postStart + leftSize - 1);
//        solve(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
//
//    }
//
//}
