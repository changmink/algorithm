package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2018. 3. 16..
 */
public class BJ1991 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[][] input = new int[n][2];

        for(int i = 0; i < n; ++i){

            String nodes = sc.nextLine();
            int node = nodes.charAt(0) - 'A';
            char l = nodes.charAt(2);
            char r = nodes.charAt(4);

            if(l == '.') {
                input[node][0] = -1;
            }
            else {
                input[node][0] = l - 'A';
            }

            if(r == '.'){
                input[node][1] = -1;
            }
            else {
                input[node][1] = r - 'A';
            }
        }

        preorder(input, 0);
        System.out.println();
        inorder(input, 0);
        System.out.println();
        postorder(input, 0);
    }

    private static void preorder(int[][] input, int i) {
        if(i == -1) return;
        System.out.print((char)(i + 'A'));
        preorder(input, input[i][0]);
        preorder(input, input[i][1]);
    }

    private static void inorder(int[][] input, int i) {
        if(i == -1) return;
        inorder(input, input[i][0]);
        System.out.print((char)(i + 'A'));
        inorder(input, input[i][1]);
    }

    private static void postorder(int[][] input, int i) {
        if(i == -1) return;
        postorder(input, input[i][0]);
        postorder(input, input[i][1]);
        System.out.print((char)(i + 'A'));
    }

}
