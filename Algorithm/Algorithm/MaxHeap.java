package Algorithm;

/**
 * Created by changmin on 2017. 12. 23..
 */
public class MaxHeap {
    public static final int heapSize = 1000001;
    public static int[] heap = new int[heapSize];
    public static int hn = 0;

    public static void push(int x){
        heap[++hn] = x;
        for(int i  = hn; i > 1; i /= 2){
            // i/2는 parent를 뜻함
            if(heap[i/2] < heap[i]){
                int temp = heap[i/2];
                heap[i/2] = heap[i];
                heap[i] = temp;
            }else{
                break;
            }
        }
    }

    public static int pop(){
        int output = heap[1];

        heap[1] = heap[hn];
        heap[hn--] = 0;

        for(int i = 1; i * 2 <= hn;){
            //i * 2와 i * 2 + 1은 이진트리의 각 자식의
            if(heap[i] > heap[i * 2] && heap[i] > heap[i * 2 + 1]){
                break;
            }else if(heap[i * 2] > heap[i * 2 + 1]){
                int temp = heap[i];
                heap[i] = heap[i * 2];
                heap[i * 2] = temp;
                i = i * 2;
            }else{
                int temp = heapSize;
                heap[i] = heap[i * 2 + 1];
                heap[i * 2 + 1] = temp;
                i = i * 2 + 1;
            }
        }

        return output;
    }
}
