package crackInterview.chap2;

import java.util.*;

/**
 * Created by changmin on 2018. 6. 12..
 */
public class P1 {

    /**
     * 해시테이블 이용하기
     * */
    public List<Integer> removeDuplication(List<Integer> input){
        Set<Integer> hs = new HashSet<>();
        List<Integer> output = new LinkedList<>();
        for(int i = 0; i < input.size(); ++i){
            int value = input.get(i);
            if(!hs.contains(value)){
                hs.add(value);
                output.add(value);
            }
        }

        return output;
    }

    /**
     * 자료구조 없이 해결
     */
    public List<Integer> removeDuplication2(List<Integer> input){
        for(int i = 0; i < input.size(); ++i){
            for(int j = i + 1; j < input.size(); ++j){
                if(input.get(i) == input.get(j)){
                    input.remove(j);
                    j -= 1;
                }
            }
        }

        return input;
    }
}
