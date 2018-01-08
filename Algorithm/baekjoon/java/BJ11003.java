package baekjoon.java;

import org.omg.PortableInterceptor.*;

import java.util.*;

/**
 * Created by changmin on 2018. 1. 6..
 */
public class BJ11003 {
    static class Pair{
        int value;
        int index;
        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] input= new int[n];

        for(int i = 0; i < n; ++i){
            input[i] = sc.nextInt();
        }

        Deque<Pair> dq = new LinkedList<>();
        int[] outputs = new int[n];

        for(int i = 0; i < n; ++i){
           int current = input[i];
           if(!dq.isEmpty() && dq.peekFirst().index <= i - l){
               dq.removeFirst();
           }
           while(!dq.isEmpty() && dq.peekLast().value > current){
               dq.removeLast();
           }
           dq.addLast(new Pair(current, i));
           outputs[i] =  dq.peekFirst().value;
        }

        for(int output : outputs){
            System.out.print(output + " ");
        }
    }
}
