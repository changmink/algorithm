package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 15..
 */
public class BJ2263 {

    public static int[] inorder;
    public static int[] postorder;
    public static int[] inorderPos = new int[100001];
    public static StringBuilder output = new StringBuilder();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int inStart = 0;
        int inEnd = 3;
        int postStart = 0;
        int postEnd = 3;


        int numberOfNode = scanner.nextInt();
        inorder = new int[numberOfNode];
        postorder = new int[numberOfNode];
        postEnd = inEnd = numberOfNode - 1;

        for(int i = 0; i < numberOfNode; ++i)
            inorder[i] = scanner.nextInt();

        for(int i = 0; i < numberOfNode; ++i){
            postorder[i] = scanner.nextInt();
        }

        for(int i = 0; i < numberOfNode; ++i){
            inorderPos[inorder[i]] = i;
        }

        solve(inStart,inEnd,postStart,postEnd);
        System.out.println(output.toString());

    }

    public static void solve(int inStart, int inEnd, int postStart, int postEnd) {
        //탈출 조건
        if(inStart > inEnd || postStart > postEnd)
            return;

        int root = postorder[postEnd];
        output.append(root + " ");

        int leftSize = inorderPos[root] - inStart;
        solve(inStart, inorderPos[root] - 1, postStart, postStart + leftSize - 1);
        solve(inorderPos[root] + 1, inEnd, postStart + leftSize, postEnd - 1);

    }

}
