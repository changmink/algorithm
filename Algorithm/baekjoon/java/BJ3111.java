package baekjoon.java;

/**
 * Created by changmin on 2017. 12. 22..
 */
import java.util.*;
public class BJ3111 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       String target = scanner.nextLine();
       String input = scanner.nextLine();
       String output = removeTarget(input, target);
    }

    private static String removeTarget(String input, String target) {
        Stack<Character> l = new Stack<>();
        Stack<Character> r = new Stack<>();
        int indexL = 0;
        int indexR = input.length() - 1;

//        while(indexL < indexL && indexR >= 0){
//            char tokenL = input.charAt(indexL++);
//
//        }
        return null;
    }
}
