package crackInterview.chap1;

import java.util.*;

/**
 * Created by changmin on 2018. 6. 6..
 */
public class P2 {
   /**
    *
    * Map에서 Key만 가지고 오는 방법은 keySet()이다. Set<key의 타입>을 리턴한다.
    * HashTable은 동기를 지원하는 HashMap
    */
   /**
    * 시간 복잡도 O(n) - 3n
    * 공간 복잡도 O(n) - 2n
    * */
   public boolean isPermution(String s1, String s2){
      if(s1.length() != s2.length())
         return false;

      Map<Character, Integer> hm1 = new HashMap<>();
      Map<Character, Integer> hm2 = new HashMap<>();

      for(int i = 0; i <s1.length(); ++i){
         char token = s1.charAt(i);
         if(hm1.containsKey(token)){
            hm1.put(token, hm1.get(token) + 1);
         }else{
            hm1.put(token, 1);
         }
      }

      for(int i = 0; i <s2.length(); ++i){
         char token = s2.charAt(i);
         if(hm2.containsKey(token)){
            hm2.put(token, hm2.get(token) + 1);
         }else{
            hm2.put(token, 1);
         }
      }

      if(hm1.size() != hm2.size())
         return false;

      Set<Character> keys = hm1.keySet();
      for(char key : keys){
         if(!hm2.containsKey(key))
            return false;
         else{
            if(hm2.get(key) != hm1.get(key))
               return true;
         }
      }

      return true;
   }
}
