package baekjoon.java;

/**
 * Created by changmin on 2018. 1. 23..
 */
public class BJ1517 {
    int[] a = new int[500000];

    long solve(int start, int end){
        if(start == end){
            return 0;
        }
        int mid = (start + end)/2;
        int[] b = new int[end-start+1];
        long output = solve(start, mid) + solve(mid+1, end);
        int i = start;
        int j = mid+1;
        int k = 0;

        while(i <= mid || j <=end){
            //j > end이면 else케이스는 안되고 나머지를 채운다. i > mid 이면 반대가 됨 -> 아래 나오는 while문 제거 가능
            if(i <= mid && (j > end || a[i] <= a[j])){
                b[k++] = a[i++];
            }else{
                //카운팅한다. 인버스인 경우 개수만큼 카운트 한다.
                output += (long)(mid - i + 1);
                b[k++] = a[j++];
            }
        }

        for(i = start; i <= end; ++i){
            a[i] = b[i - start];
        }
        return output;
    }
}
