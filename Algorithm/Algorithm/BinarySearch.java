package Algorithm;

/**
 * Created by changmin on 2017. 12. 14..
 */
public class BinarySearch {
    public static int binarySearch(int[] inputs, int value){
        int left = 0;
        int right = inputs.length-1;
        int mid = 0;
        while(left < right){
            mid = (left + right) / 2;
            if(value < inputs[mid]){
                right = mid -1;
            }
            else if(value > inputs[mid]){
                left = mid + 1;
            }
            else{
                return inputs[mid];
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] inputs;
        int value;
        int output;

        inputs = new int[]{1,2,3,4,5,6,7,8};
        value = 8;
        output = binarySearch(inputs, value);
        System.out.println(output);
    }
}
