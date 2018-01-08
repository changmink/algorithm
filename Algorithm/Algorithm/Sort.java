package Algorithm;

/**
 * Created by changmin on 2017. 12. 14..
 */
public class Sort {
    public static void mergeSort(int[] inputs){
        sort(inputs, 0, inputs.length - 1);
    }

    public static void sort(int[] inputs, int start, int end) {
        if(start == end){
            return;
        }

        int mid = (start + end) / 2;

        sort(inputs, start, mid);
        sort(inputs, mid + 1, end);
        merge(inputs, start, end);
    }

    public static void merge(int[] inputs, int start, int end) {
        int mid = (start + end) / 2;
        int i = start;
        int j = mid + 1;
        int index = 0;
        int[] temp = new int[end - start + 1];

        while(i <= mid && j <= end) {
            if (inputs[i] < inputs[j]) {
                temp[index++] = inputs[i++];
            } else {// inputs[i] >
                temp[index++] = inputs[j++];
            }
        }

        while(i <= mid) temp[index++] = inputs[i++];
        while(j <= end) temp[index++] = inputs[j++];

        index = 0;
        for(int k = start; k <= end; ++k){
            inputs[k] = temp[index++];
        }
    }

    public static void main(String[] args){
        int[] inputs = new int[]{6,3,7,5,8,2,4,1};
        mergeSort(inputs);
        for(int i = 0; i < inputs.length; ++i){
            System.out.print(inputs[i] + " ");
        }
    }
}
