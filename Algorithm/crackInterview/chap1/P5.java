package crackInterview.chap1;

/**
 * Created by changmin on 2018. 6. 6..
 */
public class P5 {
    public boolean differ1(String s1, String s2){
        int diffLength = Math.abs(s1.length() - s2.length());
        if(diffLength > 1){
            return false;
        }
        else if(diffLength == 1){
            String longs;
            String shorts;
            if(s1.length() > s2.length()){
                longs = s1;
                shorts = s2;
            }else{
                longs = s2;
                shorts = s1;
            }
            int j = 0;
            int count = 0;
            for(int i = 0; i < shorts.length(); ++i){
                if(shorts.charAt(i) != longs.charAt(j)){
                    if(count > 0) return false;
                    count += 1;
                    j += 1;
                }
                j += 1;
            }
            return true;
        }
        else{
            int count = 0;
            for(int i = 0; i < s1.length(); ++i){
                if(s1.charAt(i) != s2.charAt(i)){
                    count += 1;
                    if(count > 1) return false;
                }
            }

            return true;
        }
    }
}
