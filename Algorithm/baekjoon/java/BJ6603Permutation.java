package baekjoon.java;

import java.util.*;

/**
 * 순열을 사용함
 */
public class BJ6603Permutation {
    public static boolean nextPermutation(int[] input){
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

    public static void getCase(int k, int[] numbers){
        List<Integer> d = new ArrayList<>();
        for(int i  = 0; i < k - 6; ++i){
            d.add(0);
        }

        for(int i = 0; i < 6; ++i){
            d.add(1);
        }
        int[] selected = new int[d.size()];

        for(int i = 0; i < d.size(); ++i){
            selected[i] = d.get(i);
        }

        List<int[]> output = new ArrayList<>();
        do{
            int[] current = new int[6];
            int index = 0;
            for(int i = 0; i < k; ++i){
                if(selected[i] == 1){
                   current[index++] = numbers[i];
                }
            }
            output.add(current);
        }while(nextPermutation(selected));

        int[][] result = new int[output.size()][6];
        for(int i = 0; i < result.length; ++i){
            for(int j = 0; j < 6; ++j){
                result[i][j] = output.get(i)[j];
            }
        }

        Arrays.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for(int i = 0; i < o1.length; ++i){
                    if(o1[i] < o2[i])
                        return -1;
                }
                return 1;
            }
        });


        for(int[] selects : result){
            for(int i = 0; i < 6; ++i){
                System.out.print(selects[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        while(size != 0){
            int[] numbers = new int[size];
            for(int i = 0; i < size; ++i){
                numbers[i] = scanner.nextInt();
            }
            getCase(size, numbers);
            System.out.println();
            size = scanner.nextInt();
        }
    }
}
