package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 23..
 */
public class BJ12767 {
    class Node{
        int val;
        Node left;
        Node right;

        public Node() {
            this.val = 0;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Set<String> s = new TreeSet<>();
        for(int k = 0; k < n; ++k){
            //List<Integer> a = new ArrayList<>();
            int[] a  = new int[m];
            for(int i = 0; i < m; ++i){
                a[i] = scanner.nextInt();
            }
        }
    }
}
