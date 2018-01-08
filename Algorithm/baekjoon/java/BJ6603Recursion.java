package baekjoon.java;

import java.util.*;

/**
 * Created by changmin on 2017. 12. 20..
 */
public class BJ6603Recursion {
    public static List<Integer> output;
    public static void solve(List<Integer> numbers, int index, int cnt){
        if(cnt == 6){
            for(int num : output){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        int n = numbers.size();
        if(n == index) return;
        output.add(numbers.get(index));
        solve(numbers, index + 1, cnt + 1);
        output.remove(output.size()-1);
        solve(numbers, index + 1, cnt);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while(n != 0) {
            output = new ArrayList<>();
            List<Integer> numbers = new ArrayList<>();
            for(int i = 0 ;i < n; ++i){
                numbers.add(scanner.nextInt());
            }
            solve(numbers, 0, 0);
            System.out.println();
            n = scanner.nextInt();
        }
    }
}
