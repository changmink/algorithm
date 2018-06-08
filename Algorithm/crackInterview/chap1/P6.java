package crackInterview.chap1;

/**
 * Created by changmin on 2018. 6. 6..
 */
public class P6 {
    public String runLength(String input){
        StringBuilder stb = new StringBuilder();
        for(int i = 0; i < input.length(); ++i){
            stb.append(input.charAt(i));

            if(i+1 >= input.length()) break;

            int count = 0;
            if(input.charAt(i+1) == input.charAt(i)){
                count = 2;
                i += 1;
                while(i+1 < input.length() && input.charAt(i) == input.charAt(i+1)){
                    i += 1;
                    count += 1;
                }
                stb.append(count);
            }
        }

        if(stb.length() > input.length()) return input;
        else return stb.toString();
    }
}
