package baekjoon.java;
import java.util.*;
public class BJ10816Bound {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cards = new int[n];
        for(int i = 0; i < n; ++i){
           cards[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] values = new int[m];
        for(int i = 0; i < m; ++i){
            values[i] = sc.nextInt();
        }

        System.out.println(howManyNumbers(cards, values));

    }

    public static String howManyNumbers(int[] n, int[] m){
        Arrays.sort(n);
        StringBuilder output = new StringBuilder();

        for(int value : m){
           int right = lowerBound(n, value, 0, n.length - 1);
           if(right < n.length){
               int left = upperBound(n, value, 0, n.length -1);
               output.append(left - right);
           }else {
               output.append(0);
           }
           output.append(" ");
        }

        return output.toString();
    }

    private static int upperBound(int[] n, int value, int start, int end) {
        int mid = 0;
        //모든 원소가 value 보다 작다면 end+1을 출력해야한다.
        end += 1;
        while(end > start){
            mid = (start + end) / 2;
            if(n[mid] <= value) start = mid + 1;
            else end = mid;
        }
        return end + 1;
    }

    private static int lowerBound(int[] n, int value, int start, int end) {
        int mid = 0;
        //모든 원소가 value 보다 작다면 end+1을 출력해야한다.
        end += 1;
        while(end > start){
            mid = (start + end) / 2;
            if(n[mid] < value) start = mid + 1;
            else end = mid;
        }
        return end + 1;
    }

}
