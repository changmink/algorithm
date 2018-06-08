package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 16..
 */
import java.util.*;
public class BJ10815 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cards[] = new int[n];

        for(int i = 0; i < n; ++i){
            cards[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int values[] = new int[m];

        for(int i = 0; i < m; ++i){
            values[i] = sc.nextInt();
        }

        String output = findNumber(cards, values);
        System.out.println(output);

    }

    public static String findNumber(int[] n, int[] values){
        Arrays.sort(n);
        StringBuilder output = new StringBuilder();

        for(int value : values){
            if(binarySearch(n, value, 0, n.length-1)){
                output.append(1 + " ");
            }else{
                output.append(0 + " ");
            }
        }

        return output.toString();
    }
    static boolean binarySearch(int[] n, int value, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            if(n[mid] > value){
                end = mid - 1;
            }
            else if (n[mid] < value){
                start = mid + 1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
