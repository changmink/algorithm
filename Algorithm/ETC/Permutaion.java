package ETC;

/**
 * Created by changmin on 2017. 12. 17..
 */
public class Permutaion {
    public boolean nextPermutation(int[] input){
        int i = input.length - 1;
        //뒤에서 부터 내림 차순이 안되는 i를 찾는다
        while(i > 0 && input[i-1] >= input[i]) i -= 1;

        //마지막인 경우
        if(i <= 0) return false;

        //오름 차순이 안되는 j를 찾아 i와 바꾼다
        int j = input.length - 1;
        while(input[j] <= input[i-1]) j -= 1;

        int temp = input[i-1];
        input[i-1] = input[j];
        input[j] = temp;

        //스왑한다.
        j = input.length - 1;
        while(i < j){
            temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            i += 1; j -= 1;
        }

        return true;
    }

    public boolean prevPermutation(int[] inputs) {
        int i = inputs.length - 1;

        while (i > 0 && inputs[i - 1] < inputs[i]) i--;

        if (i <= 0) return false;

        int j = inputs.length - 1;
        while (inputs[j] >= inputs[i - 1]) --j;
        int temp = inputs[i - 1];
        inputs[i - 1] = inputs[j];
        inputs[j] = temp;

        j = inputs.length - 1;
        while (i < j) {
            temp = inputs[i - 1];
            inputs[i - 1] = inputs[j];
            inputs[j] = temp;
            ++i;
            --j;
        }

        return true;
    }
}
