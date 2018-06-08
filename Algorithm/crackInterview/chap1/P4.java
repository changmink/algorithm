package crackInterview.chap1;

import java.util.*;

/**
 * Created by changmin on 2018. 6. 6..
 */
public class P4 {
    /**
     * 반으로 나눠서 생각 하기 -> 이 경우 공백이 문제가됨
     * 홀수인경우 -> 가운데는 제외 됨 3/2 = 1
     * 짝수인 경우 반
     *
     * 시작 인덱스, 마지막 인덱스 부터 비교하기, 공백이면 넘어가기
     * 인덱스가 엇갈리는 순간 종료
     *
     */
    public boolean isPal(String input){
        int forward = 0;
        int backend = input.length() - 1;

        while(forward < backend){
            char fowardToken = input.charAt(forward);
            char backendToken = input.charAt(backend);

            if(fowardToken == ' '){
                forward += 1;
                continue;
            }

            if(backendToken == ' '){
                backend -= 1;
                continue;
            }

            if(fowardToken != backendToken)
                return false;

            forward += 1;
            backend -= 1;
        }
        return true;
    }

    /**
     * 틀린 답
     * 홀수의 수를 센다 -> 오답, 홀수가 항상 중앙에 온다는 보장이 없다.
     * 짝수만 -> 반례 오어오어
     */


//    public boolean isPal(String input){
//        Map<Character, Integer> tokenCounter = new HashMap<>();
//
//        for(int i = 0; i < input.length(); ++i){
//            char token = input.charAt(i);
//            if(tokenCounter.containsKey(token)){
//                tokenCounter.put(token, tokenCounter.get(token) + 1);
//            }else{
//                tokenCounter.put(token, 1);
//            }
//        }
//
//
//        int oddCount = 0;
//        Set<Character> tokens = tokenCounter.keySet();
//        for(char token : tokens){
//            if(token == ' ') continue;;
//            if(tokenCounter.get(token) % 2 != 0){
//               oddCount += 1;
//               if(oddCount > 1) return false;
//            }
//        }
//
//        return true;
//    }
}
