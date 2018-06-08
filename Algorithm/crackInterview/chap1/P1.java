package crackInterview.chap1;

/**
 * Created by changmin on 2018. 6. 6..
 */
import java.util.*;

public class P1 {
    /**
     * Set의 입력 -> add(value)
     * Map의 입력 -> put(key, value)
     * 자료 구조를 쓰지 않고 풀 수 있는 방법 ? boolean[Character.MAX_VALUE]? -> 비트 백터
     * */
    /**
     * 시간 복잡도 O(n)
     * 공간 복잡도 O(n)
     * */
    public boolean isUniqueCharString(String input){
        Set<Character> table = new HashSet<>();
        for(int i = 0; i < input.length(); ++i){
            char token = input.charAt(i);
            if(table.contains(token)){
                return false;
            }else{
                table.add(token);
            }
        }

        return true;
    }

    /**
     * 시간 복잡도 O(n)
     * 공간 복잡도 1
     */
    public boolean isUniqueCharStringBitVector(String input){
        int vector = 0;
        for(int i = 0; i < input.length(); ++i){
            int token = (int)input.charAt(i);
            if((vector & ( 1 << token)) > 0)
               return false;
            else {
                vector |= (1 << token);
            }
        }
        return true;
    }
}
