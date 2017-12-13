package baekjoon;

import java.util.*;

/**
 * Created by changmin on 2017. 9. 22..
 */
public class BJ1152 {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        String[] words = input.split(" ");

        for(String word : words){
            if(hash.containsKey(word)){
                int count = hash.get(word);
                hash.put(word, count + 1);
            }
            else{
                hash.put(word, 1);
            }
        }
        System.out.println(hash.size());

    }
}
